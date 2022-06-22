package org.example.data.scrapper.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry {

    @JsonProperty("Country")
    private String country;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("Slug")
    private String slug;

    @JsonProperty("NewConfirmed")
    private long newConfirmed;

    @JsonProperty("TotalConfirmed")
    private long totalConfirmed;

    @JsonProperty("NewDeaths")
    private long newDeaths;

    @JsonProperty("TotalDeaths")
    private long totalDeaths;

    @JsonProperty("NewRecovered")
    private long newRecovered;

    @JsonProperty("TotalRecovered")
    private long totalRecovered;

    @JsonProperty("Date")
    private String date;
}
