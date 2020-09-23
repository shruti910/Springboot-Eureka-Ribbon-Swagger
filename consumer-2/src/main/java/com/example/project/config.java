package com.example.project;

import com.example.project.service.ApiClient;
import com.example.project.service.RestTemplateApiClient;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class config {
  
@Bean
	public ApiClient client() {
		return new RestTemplateApiClient();
	}
        
        // for local environment
	@Bean
//	@Profile("local")
	public RestTemplate restTemplateLocal(RestTemplateBuilder builder) {
		RestTemplate restTemplate = builder.build();
		return restTemplate;
	}
}
