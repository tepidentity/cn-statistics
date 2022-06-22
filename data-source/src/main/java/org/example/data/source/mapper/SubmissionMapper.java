package org.example.data.source.mapper;

import org.example.data.source.dto.submission.SubmissionDto;
import org.example.data.source.entity.Country;
import org.example.data.source.entity.Statistics;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {

    @Mapping(source = "country", target = "name")
    @Mapping(source = "countryCode", target = "code")
    Country submissionToCountry(SubmissionDto dto);

    @Mapping(target = "country", ignore = true)
    Statistics submissionToStatistics(SubmissionDto dto);
}
