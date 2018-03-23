package com.congifclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RefreshScope
@SpringBootApplication
@Controller
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${foo}")
	String foo;

	@Value("${democonfigclient.message}")
	String message;

	@Value("${name}")
	String name;

	//   调取 http://localhost:8881/actuator/bus-refresh 实现配置的动态刷新
	@ResponseBody
	@RequestMapping(value = "/hi")
	public String hi(){
		return foo+message+name;
	}

}
