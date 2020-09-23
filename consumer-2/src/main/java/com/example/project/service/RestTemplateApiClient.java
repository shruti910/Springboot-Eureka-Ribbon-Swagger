/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.project.service;

import com.example.project.Inventory;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author User
 */
public class RestTemplateApiClient implements ApiClient {
//    @Value("${producer.management.baseUrl}")
	private final String baseUrl="/api/";   //base url of producer api
    
    @Autowired
	private final RestTemplate restTemplate;
	
    @Autowired
	private LoadBalancerClient loadBalancer;
    
    public RestTemplateApiClient() {
		this.restTemplate = new RestTemplate();
	}

    @Override
    public ResponseEntity<Inventory> postRequestToEureka(Inventory inv) {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 ServiceInstance serviceInstance = null;
		HttpEntity<?> httpEntity = new HttpEntity<>(inv);
		serviceInstance = loadBalancer.choose("spring-eureka-producer");
		String newUrl = serviceInstance.getUri().toString();
                System.out.println("****************************************************************");
                System.out.println(newUrl); //localhost:8080
		newUrl = newUrl + baseUrl + "create";  
                  System.out.println("****************************************************************");
                 System.out.println(newUrl);  //localhost:8080/api/create
		return restTemplate.exchange(newUrl, HttpMethod.POST,httpEntity,Inventory.class);
    
    
    
    }

    @Override
    public <T> T getRequestToEureka(String getUri, Class<T> tClass) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                ServiceInstance serviceInstance = null;
		serviceInstance = loadBalancer.choose("spring-eureka-producer");
		getUri = serviceInstance.getUri().toString();
                  System.out.println("****************************************************************");
		getUri = getUri + baseUrl ;
                  System.out.println(getUri);    //localhost:8080/api/
		return restTemplate.getForObject(getUri, tClass);
    
    
    }

    @Override
    public ResponseEntity<Inventory> putRequestToEureka(Inventory inv, int invId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                ServiceInstance serviceInstance = null;
		HttpEntity<?> httpEntity = new HttpEntity<>(inv);
		serviceInstance = loadBalancer.choose("spring-eureka-producer");
		String newUrl = serviceInstance.getUri().toString();
		newUrl = newUrl + baseUrl + "update/" + invId;
		return restTemplate.exchange(newUrl, HttpMethod.PUT,httpEntity,Inventory.class);
    
    }

    @Override
    public Inventory getByIdRequestToEureka(int invId, Class<Object> objectClass) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                ServiceInstance serviceInstance = null;
		serviceInstance = loadBalancer.choose("spring-eureka-producer");
		String newUrl = serviceInstance.getUri().toString();
		newUrl = newUrl + baseUrl +"/"+ invId;
		return restTemplate.getForObject(newUrl, Inventory.class);
    
    
    }

    @Override
    public void deleteRequestToEureka(int invId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                ServiceInstance serviceInstance = null;
		serviceInstance = loadBalancer.choose("spring-eureka-producer");
		String newUrl = serviceInstance.getUri().toString();
		newUrl = newUrl + baseUrl +"delete/"+ invId;
		restTemplate.delete(newUrl);
    
    
    
    }
    
}
