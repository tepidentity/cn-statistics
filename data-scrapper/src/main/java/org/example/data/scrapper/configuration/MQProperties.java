package org.example.data.scrapper.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "messaging")
public class MQProperties {

    private String queue;
    private String exchange;
    private String routingKey;
}
