package org.example.data.store.mapper;

import org.example.data.store.dto.CountrySummaryDto;
import org.example.data.store.entity.Country;
import org.example.data.store.entity.Statistics;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StatisticsMapper.class})
public interface CountryMapper {

    @Mapping(source = "country.name", target = "country")
    @Mapping(source = "country.code", target = "countryCode")
    @Mapping(source = "country.slug", target = "slug")
    @Mapping(source = "statistics", target = "statistics")
    CountrySummaryDto toCountrySummaryDto(Country country, Statistics statistics);
}
