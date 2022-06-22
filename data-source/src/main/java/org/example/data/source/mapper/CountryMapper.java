package org.example.data.source.mapper;

import org.example.data.source.dto.CountrySummaryDto;
import org.example.data.source.entity.Country;
import org.example.data.source.entity.Statistics;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StatisticsMapper.class})
public interface CountryMapper {

    @Mapping(source = "country.name", target = "country")
    @Mapping(source = "country.code", target = "countryCode")
    @Mapping(source = "country.slug", target = "slug")
    @Mapping(source = "statistics", target = "statistics")
    CountrySummaryDto toStatisticsDto(Country country, Statistics statistics);
}
