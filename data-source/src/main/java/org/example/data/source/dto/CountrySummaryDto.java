package org.example.data.source.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountrySummaryDto {

    private String country;
    private String countryCode;
    private String slug;
    private StatisticsDto statistics;
}
