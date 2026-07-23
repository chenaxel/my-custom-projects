package com.axel.custools;

import com.axel.custools.config.DotaSteamConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DotaSteamConfigProperties.class)
public class CusToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CusToolsApplication.class, args);
    }

}
