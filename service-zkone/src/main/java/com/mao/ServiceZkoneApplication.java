package com.mao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@SpringBootApplication
public class ServiceZkoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceZkoneApplication.class, args);
	}

	private static final Logger LOG = Logger.getLogger(ServiceZkoneApplication.class.getName());


	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@ResponseBody
	@RequestMapping("/zkone")
	public String callHome(){
		LOG.log(Level.INFO, "calling trace service-zkone  ");
		return restTemplate.getForObject("http://localhost:8989/zktwo", String.class);
	}
	@RequestMapping("/info1")
	public String info(){
		LOG.log(Level.INFO, "calling trace service-zkone ");

		return "i'm service-zkone";

	}




}
