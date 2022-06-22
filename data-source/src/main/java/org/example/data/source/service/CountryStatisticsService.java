package org.example.data.source.service;

import org.example.data.source.dto.CountrySummaryDto;

public interface CountryStatisticsService {

    CountrySummaryDto getLatestSummaryByCountryCode(String code);
}
