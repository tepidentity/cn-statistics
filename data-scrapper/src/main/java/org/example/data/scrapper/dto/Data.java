package org.example.data.scrapper.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    @JsonProperty("Countries")
    private List<Entry> entries = new ArrayList<>();
}
