package com.axel.custools;

import com.axel.custools.config.DotaHeroConst;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootTest
class CusToolsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testHeroMap(){
        String heroName = DotaHeroConst.getHeroName(1);
        System.out.println(heroName);
    }
}
