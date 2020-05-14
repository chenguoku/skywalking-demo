package com.hh.skywalkingdemoB.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    private final static String B_SERVER_URL = "http://c-server/c";

    public String bService() {
        log.info("######B Service come in!");

        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(null);
        ResponseEntity<String> exchange = restTemplate.exchange(B_SERVER_URL, HttpMethod.GET, objectHttpEntity, String.class);
        String returnMsg = exchange.getBody();

        log.info("######B Service return message:" + returnMsg);
        return returnMsg;
    }

}
