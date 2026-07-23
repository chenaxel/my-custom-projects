package com.axel.custools.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dota.steam")
@Data
public class DotaSteamConfigProperties {
    private String apiKey;
    private Integer pageSize;
}
