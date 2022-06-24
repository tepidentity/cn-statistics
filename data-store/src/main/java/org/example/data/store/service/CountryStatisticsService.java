package org.example.data.store.service;

import org.example.data.store.dto.CountrySummaryDto;

public interface CountryStatisticsService {

    CountrySummaryDto getLatestSummaryByCountryCode(String code);
}
