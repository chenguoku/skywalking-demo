package com.hh.skywalkingdemoB.controller;

import com.hh.skywalkingdemoB.service.BService;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.slf4j.MDC;
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
 * @ClassName BController.java
 * @Description BController
 * @createTime 2020年05月03日 21:17:00
 */
@RestController
@Slf4j
public class BController {

    @Autowired
    private BService bService;

    @GetMapping("b")
    public String bController(HttpServletRequest request, HttpServletResponse response) {


        log.info("######B Controller come on!");


        Enumeration<String> headerNames = request.getHeaderNames();
        log.info("#####Sever B header begin###");
        Map headerMap = new HashMap();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            String header = request.getHeader(s);
            headerMap.put(s, header);
            System.out.println(s + ":" + header);
        }
        log.info("#####Sever B header end###");

        printTraceId();

        String returnMsg = bService.bService();
        log.info("######B Controller have return message:" + returnMsg);
        return returnMsg;
    }


    private void printTraceId() {
        Thread thread = Thread.currentThread();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        Map<String, String> copyOfContextMap = MDC.getCopyOfContextMap();
        String traceId = MDC.get("traceId");
        String tid = MDC.get("tid");

        log.info("traceId:" + traceId);
        log.info("tid:" + tid);

    }

}
