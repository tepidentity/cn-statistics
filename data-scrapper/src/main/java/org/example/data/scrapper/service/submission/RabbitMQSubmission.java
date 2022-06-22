package org.example.data.scrapper.service.submission;

import lombok.extern.slf4j.Slf4j;
import org.example.data.scrapper.configuration.MQProperties;
import org.example.data.scrapper.dto.Data;
import org.example.data.scrapper.mapper.CountryMapper;
import org.example.data.scrapper.service.DataSubmission;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class RabbitMQSubmission implements DataSubmission {

    private final RabbitTemplate template;
    private final MQProperties mqProperties;
    private final CountryMapper countryMapper;

    @Autowired
    public RabbitMQSubmission(RabbitTemplate template, MQProperties mqProperties, CountryMapper countryMapper) {

        this.template = template;
        this.mqProperties = mqProperties;
        this.countryMapper = countryMapper;
    }

    @Override
    public void submit(Data data) {

        Objects.requireNonNull(data, "Data may not be null!");
        Objects.requireNonNull(data.getEntries(), "Data entries are missing!");

        log.info("Submitting data entries...");
        try {

            data.getEntries().forEach(entry -> publish(countryMapper.toSubmission(entry, data.getDate())));

        } catch (Exception ex) {

            log.error("Failed to publish all data entries! {}", ex.getMessage(), ex);

            throw new RuntimeException("Submission failure!");
        }
        log.info("Submitted all data entries without errors...");
    }

    private <T> void publish(T submission) {

        template.convertAndSend(mqProperties.getExchange(), mqProperties.getRoutingKey(), submission);
    }
}
