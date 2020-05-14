package com.hh.skywalkingdemoC;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@NacosPropertySource(dataId = "c-server", groupId = "DEFAULT_GROUP", autoRefreshed = true)
@EnableDiscoveryClient
public class SkywalkingDemoCApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkywalkingDemoCApplication.class, args);
	}

}
