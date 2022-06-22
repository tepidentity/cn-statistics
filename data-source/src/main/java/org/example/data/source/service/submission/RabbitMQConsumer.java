package org.example.data.source.service.submission;

import lombok.extern.slf4j.Slf4j;
import org.example.data.source.dto.submission.SubmissionDto;
import org.example.data.source.entity.Country;
import org.example.data.source.entity.Statistics;
import org.example.data.source.mapper.SubmissionMapper;
import org.example.data.source.repository.CountryRepository;
import org.example.data.source.repository.StatisticsRepository;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;

@Slf4j
@Component
public class RabbitMQConsumer implements DataConsumer {

    private final SubmissionMapper submissionMapper;
    private final CountryRepository countryRepository;
    private final StatisticsRepository statisticsRepository;

    @Autowired
    public RabbitMQConsumer(CountryRepository countryRepository, StatisticsRepository statisticsRepository,
                            SubmissionMapper submissionMapper) {

        this.countryRepository = countryRepository;
        this.statisticsRepository = statisticsRepository;
        this.submissionMapper = submissionMapper;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("#{amqpProperties.getQueue()}"),
            exchange = @Exchange("#{amqpProperties.getExchange()}"),
            key = "#{amqpProperties.getRoutingKey()}"))
    @Override
    public void consume(SubmissionDto submissionDto) {

        log.info("Consuming country submission! {}", submissionDto);

        Objects.requireNonNull(submissionDto, "Invalid submission - object is NULL!");
        Instant date = Objects.requireNonNull(submissionDto.getDate(), "Missing date for submission!");

        Country country = createOrGetCountry(submissionDto);
        boolean isObsolete = statisticsRepository.existsByCountryAndDateGreaterThanEqual(country, date);

        if (isObsolete) {

            log.info("Statistics are obsolete");
            return;
        }

        Statistics statistics = submissionMapper.submissionToStatistics(submissionDto);
        country.addStatistics(statistics);
        countryRepository.save(country);

        log.info("Consuming submission finished successfully! {}", submissionDto);
    }

    private Country createOrGetCountry(SubmissionDto submissionDto) {

        Objects.requireNonNull(submissionDto.getCountryCode(), "Missing country code for submission!");

        return countryRepository.findByCode(submissionDto.getCountryCode())
                .orElseGet(() -> createCountry(submissionDto));
    }

    private Country createCountry(SubmissionDto submissionDto) {

        Country country = submissionMapper.submissionToCountry(submissionDto);
        return countryRepository.save(country);
    }
}
