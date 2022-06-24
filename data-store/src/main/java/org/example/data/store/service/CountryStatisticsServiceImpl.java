package org.example.data.store.service;

import lombok.extern.slf4j.Slf4j;
import org.example.data.store.dto.CountrySummaryDto;
import org.example.data.store.entity.Country;
import org.example.data.store.entity.Statistics;
import org.example.data.store.mapper.CountryMapper;
import org.example.data.store.repository.CountryRepository;
import org.example.data.store.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CountryStatisticsServiceImpl implements CountryStatisticsService {

    private final CountryRepository countryRepository;
    private final StatisticsRepository statisticsRepository;
    private final CountryMapper countryMapper;

    @Autowired
    public CountryStatisticsServiceImpl(CountryRepository countryRepository, StatisticsRepository statisticsRepository,
                                        CountryMapper countryMapper) {

        this.countryRepository = countryRepository;
        this.statisticsRepository = statisticsRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public CountrySummaryDto getLatestSummaryByCountryCode(String code) {

        log.info("Retrieving country with code \"{}\".", code);

        Country country = countryRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("Code not found + " + code));

        Statistics statistics = statisticsRepository.findByCountryIdAndMaxDate(country.getId())
                .orElseGet(Statistics::new);

        return countryMapper.toCountrySummaryDto(country, statistics);
    }
}
