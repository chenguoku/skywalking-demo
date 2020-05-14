package com.hh.skywalkingdemoC.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName CService.java
 * @Description CService
 * @createTime 2020年05月04日 17:59:00
 */
@Service
@Slf4j
public class CService {

    public String cService() {
        log.info("######c Service come in!");
        log.info("######c Service return message!");
        return "This is C Server";
    }

}
