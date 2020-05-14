package com.hh.skywalkingdemoC.controller;

import com.hh.skywalkingdemoC.service.CService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenguoku
 * @version 1.0.0
 * @ClassName CController.java
 * @Description TODO
 * @createTime 2020年05月03日 21:17:00
 */
@RestController
@Slf4j
public class CController {

    @Autowired
    private CService cService;

    @GetMapping("c")
    public String cController(HttpServletRequest request, HttpServletResponse response) {
        log.info("###### C Controller come in！");

        Enumeration<String> headerNames = request.getHeaderNames();
        log.info("#####Sever C header begin###");
        Map headerMap = new HashMap();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            String header = request.getHeader(s);
            headerMap.put(s, header);
            System.out.println(s + ":" + header);
        }
        log.info("#####Sever C header end###");


        String returnMsg = cService.cService();
        log.info("###### C Controller have a return message:" + returnMsg);
        return returnMsg;
    }

}
