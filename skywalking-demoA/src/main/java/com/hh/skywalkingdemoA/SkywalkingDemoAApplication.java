package com.hh.skywalkingdemoA;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@NacosPropertySource(dataId = "a-server", groupId = "DEFAULT_GROUP", autoRefreshed = true)
@EnableDiscoveryClient
public class SkywalkingDemoAApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkywalkingDemoAApplication.class, args);
	}

}
