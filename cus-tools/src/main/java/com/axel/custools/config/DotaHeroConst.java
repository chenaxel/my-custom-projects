package com.axel.custools.config;
import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class DotaHeroConst {
    private static Map<Integer, Hero> HERO_MAP;

    static {
        Map<Integer, Hero> tempMap = new HashMap<>(150);
        try (InputStream inputStream = new ClassPathResource("hero.json").getInputStream()) {
            // 正确解析JSON数组，原代码直接传Hero.class会解析失败
            String jsonStr = IoUtil.readUtf8(inputStream);
            List<Hero> heroList = JSON.parseObject(jsonStr, new TypeReference<>() {
            });

            if (heroList == null || heroList.isEmpty()) {
                log.warn("hero.json 英雄数据为空，英雄映射失效");
            } else {
                heroList.forEach(hero -> tempMap.put(hero.getId(), hero));
                log.info("加载Dota英雄映射完成，共 {} 个英雄", tempMap.size());
            }
        } catch (Exception e) {
            log.error("初始化Dota英雄映射失败", e);
        }
        // 包装为不可修改Map，防止外部篡改缓存
        HERO_MAP = Collections.unmodifiableMap(tempMap);
    }

    public static String getHeroName(Integer heroId) {
        Hero hero = HERO_MAP.get(heroId);
        if (hero == null) return "未知英雄";
        return hero.getLocalizedName();
    }

    @Data
    static class Hero {
        private String name;
        private int id;
        @JsonProperty("localized_name")
        private String localizedName;
    }
}