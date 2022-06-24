package org.example.statistics.controller;

import org.example.statistics.client.StatisticsClient;
import org.example.statistics.dto.CountrySummaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/country")
public class StatisticsController {

    private final StatisticsClient statisticsClient;

    @Autowired
    public StatisticsController(StatisticsClient statisticsClient) {

        this.statisticsClient = statisticsClient;
    }

    @GetMapping("/{countryCode}")
    public ResponseEntity<CountrySummaryDto> getSummary(@PathVariable @Pattern(regexp = "^[A-Z]{2}$") String countryCode) {

        return ResponseEntity.ok(statisticsClient.getSummary(countryCode));
    }
}
