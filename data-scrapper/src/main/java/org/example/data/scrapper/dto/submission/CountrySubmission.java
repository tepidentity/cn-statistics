package org.example.data.scrapper.dto.submission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountrySubmission {

    private String country;
    private String countryCode;
    private String slug;
    private long newConfirmed;
    private long totalConfirmed;
    private long newDeaths;
    private long totalDeaths;
    private long newRecovered;
    private long totalRecovered;
    private String date;
}
