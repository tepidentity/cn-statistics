package org.example.data.scrapper.mapper;

import org.example.data.scrapper.dto.Entry;
import org.example.data.scrapper.dto.submission.CountrySubmission;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountrySubmission toSubmission(Entry entry, String date) {

        return CountrySubmission.builder()
                .country(entry.getCountry())
                .countryCode(entry.getCountryCode())
                .slug(entry.getSlug())
                .newConfirmed(entry.getNewConfirmed())
                .totalConfirmed(entry.getTotalConfirmed())
                .newDeaths(entry.getNewDeaths())
                .totalConfirmed(entry.getTotalConfirmed())
                .newRecovered(entry.getNewRecovered())
                .totalRecovered(entry.getTotalRecovered())
                .date(date)
                .build();
    }
}
