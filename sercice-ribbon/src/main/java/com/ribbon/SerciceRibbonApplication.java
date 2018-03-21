package com.ribbon;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
//断路器
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SerciceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SerciceRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	//要看Hystrix监控仪表盘  要注册下面的bean
	@Bean
	RegistrationBean registration(){
		return new ServletRegistrationBean(new HystrixMetricsStreamServlet(), "/hystrix.stream");
	}
}
