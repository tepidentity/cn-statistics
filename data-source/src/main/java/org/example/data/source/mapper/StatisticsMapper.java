package org.example.data.source.mapper;

import org.example.data.source.dto.StatisticsDto;
import org.example.data.source.entity.Statistics;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatisticsMapper {

    StatisticsDto toStatisticsDto(Statistics statistics);
}
