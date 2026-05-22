package com.axel.expressapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "logistics.kuaidi100")
@Data
public class Kuaidi100Config {
    private String queryUrl;
    private String mapTrackUrl;
    private String customer;
    private String key;
    private String phone;
}
