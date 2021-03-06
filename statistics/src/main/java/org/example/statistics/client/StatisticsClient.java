package org.example.statistics.client;

import org.example.statistics.dto.CountrySummaryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "data-store-service")
public interface StatisticsClient {

    @RequestMapping(value = "/country/{code}", method = RequestMethod.GET)
    CountrySummaryDto getSummary(@PathVariable("code") String countryCode);
}
