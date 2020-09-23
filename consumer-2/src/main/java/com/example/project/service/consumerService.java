package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.project.Inventory;
import java.util.List;
import java.util.Optional;


@Service
public class consumerService {
	

	@Autowired
	private ApiClient apiClient;
        
        public Inventory addInventory(Inventory inv) {
		ResponseEntity<Inventory> responseEntity = apiClient.postRequestToEureka(inv);
		return responseEntity.getBody();
	}

	@SuppressWarnings("unchecked")
	public List<Inventory> getAllInventoryInfo() {
		String getUri = null;
		List<Inventory> inv = (List<Inventory>) apiClient.getRequestToEureka(getUri, Object.class);
		return inv; 
	}

	public void updateInventory(Inventory inv, int invId) {
		ResponseEntity<Inventory> responseEntity = apiClient.putRequestToEureka(inv, invId);
		responseEntity.getBody();
	}

	public Inventory getInventoryByinvId(int invId) {
		Inventory inv = (Inventory) apiClient.getByIdRequestToEureka(invId, Object.class);
		return inv;
	}

	public void deleteById(int invId) {
		apiClient.deleteRequestToEureka(invId);
	}

	

	
	

}
