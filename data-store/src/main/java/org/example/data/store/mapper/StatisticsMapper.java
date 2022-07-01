package org.example.data.store.mapper;

import org.example.data.store.dto.StatisticsDto;
import org.example.data.store.entity.Statistics;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatisticsMapper {

    StatisticsDto toStatisticsDto(Statistics statistics);
}
