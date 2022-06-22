package org.example.data.source.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.data.source.dto.CountrySummaryDto;
import org.example.data.source.service.CountryStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/country")
public class CountryStatisticsController {

    private final CountryStatisticsService countryStatisticsService;

    public CountryStatisticsController(CountryStatisticsService countryStatisticsService) {

        this.countryStatisticsService = countryStatisticsService;
    }

    @GetMapping(path = "/{code}")
    public CountrySummaryDto getCountrySummary(@PathVariable("code") String countryCode) {

        log.info("Retrieving country with code \"{}\".", countryCode);
        return countryStatisticsService.getLatestSummaryByCountryCode(countryCode);
    }
}
