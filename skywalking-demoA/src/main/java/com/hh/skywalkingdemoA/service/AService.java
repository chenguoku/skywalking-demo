package com.hh.skywalkingdemoA.service;

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
 * @ClassName AService.java
 * @Description AService
 * @createTime 2020年05月04日 17:59:00
 */
@Service
@Slf4j
public class AService {

    @Autowired
    private RestTemplate restTemplate;

    private final static String B_SERVER_URL = "http://b-server/b";

    public String aService() {
        log.info("######a service come in!");
        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(null);
        ResponseEntity<String> exchange = restTemplate.exchange(B_SERVER_URL, HttpMethod.GET, objectHttpEntity, String.class);
        String returnMsg = exchange.getBody();
        log.info("######a service have a back message:" + returnMsg);
        return returnMsg;
    }

}
