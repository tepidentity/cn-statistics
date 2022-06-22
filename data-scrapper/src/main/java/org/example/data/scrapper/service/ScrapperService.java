package org.example.data.scrapper.service;

import lombok.extern.slf4j.Slf4j;
import org.example.data.scrapper.dto.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@EnableScheduling
@Slf4j
public class ScrapperService {

    @Value("${scrape.url}")
    private String url;

    private final RestTemplate restTemplate;

    private final DataSubmission submission;

    @Autowired
    public ScrapperService(RestTemplate restTemplate, DataSubmission submission) {

        this.restTemplate = restTemplate;
        this.submission = submission;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(cron = "${scrape.cron}")
    public void scrape() {

        Data data = restTemplate.getForObject(url, Data.class);
        log.info("Data retrieved successfully! Total entries found: {}.\n{}", data.getEntries().size(), data);

        submission.submit(data);
    }
}
