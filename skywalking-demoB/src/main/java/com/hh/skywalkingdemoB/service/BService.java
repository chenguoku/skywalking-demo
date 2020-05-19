package com.hh.skywalkingdemoB.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName BService.java
 * @Description CService
 * @createTime 2020年05月04日 17:59:00
 */
@Service
@Slf4j
public class BService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    private final static String B_SERVER_URL = "http://c-server/c";

    public String bService() {
        log.info("######B Service come in!");

        log.info("#####B 操作 redis##开始");
        redisTemplate.opsForValue().set("test1", "2", 5L, TimeUnit.MINUTES);
        Object test1 = redisTemplate.opsForValue().get("test1");
        log.info("## redis：" + test1);

        log.info("#####B 调用C ##开始");
        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(null);
        ResponseEntity<String> exchange = restTemplate.exchange(B_SERVER_URL, HttpMethod.GET, objectHttpEntity, String.class);
        String returnMsg = exchange.getBody();
        log.info("######B Service return message:" + returnMsg);

        return returnMsg;
    }

}
