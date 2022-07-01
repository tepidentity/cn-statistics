package org.example.statistics.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountrySummaryDto {

    private String country;
    private String countryCode;
    private String slug;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {

        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {

        if (value instanceof Map) {

            ((Map<?, ?>) value).forEach((k, v) -> setAdditionalProperty(String.valueOf(k), v));

        } else if (value instanceof Iterable) {

            int i = 0;
            for (Object v : ((Iterable<?>) value)) {

                this.additionalProperties.put(name + "_" + i, v);
                i++;
            }
        } else {

            this.additionalProperties.put(name, value);
        }
    }
}
