package com.axel.custools.config;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DotaHeroConst {
    private static final Map<Integer, String> HERO_MAP = new HashMap<>();

    static {
        try {
            ClassPathResource resource = new ClassPathResource("hero.json");
            InputStream inputStream = resource.getInputStream();
            Map<String, String> tempMap = JSON.parseObject(inputStream, Map.class);
            inputStream.close();
            for (Map.Entry<String, String> entry : tempMap.entrySet()) {
                Integer hid = Integer.parseInt(entry.getKey());
                HERO_MAP.put(hid, entry.getValue());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public static String getHeroName(Integer heroId) {
        if (heroId == null) return "未知英雄";
        return HERO_MAP.getOrDefault(heroId, "英雄" + heroId);
    }
}