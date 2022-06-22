package org.example.data.scrapper.service;

import lombok.extern.slf4j.Slf4j;
import org.example.data.scrapper.configuration.MQProperties;
import org.example.data.scrapper.dto.Data;
import org.example.data.scrapper.dto.Entry;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class RabbitMQSubmission implements DataSubmission {

    private final RabbitTemplate template;
    private final MQProperties mqProperties;

    @Autowired
    public RabbitMQSubmission(RabbitTemplate template, MQProperties mqProperties) {

        this.template = template;
        this.mqProperties = mqProperties;
    }

    @Override
    public void submit(Data data) {

        Objects.requireNonNull(data, "Data may not be null!");
        Objects.requireNonNull(data.getEntries(), "Data entries are missing!");

        log.info("Submitting data entries...");
        try {
            data.getEntries().forEach(this::publishEntry);

        } catch (Exception ex) {

            log.error("Failed to publish all data entries! {}", ex.getMessage(), ex);

            throw new RuntimeException("Submission failure!");
        }
        log.info("Submitted all data entries without errors...");
    }

    private void publishEntry(Entry entry) {

        template.convertAndSend(mqProperties.getExchange(), mqProperties.getRoutingKey(), entry);
    }
}
