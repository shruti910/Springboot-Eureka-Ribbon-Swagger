/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.project.service;

import com.example.project.Inventory;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author User
 */
public interface ApiClient {
        ResponseEntity<Inventory> postRequestToEureka(Inventory inv);

	<T> T getRequestToEureka(String getUri, Class<T> tClass);

	ResponseEntity<Inventory> putRequestToEureka(Inventory inv, int invId);

	Inventory getByIdRequestToEureka(int invId, Class<Object> objectClass);

	void deleteRequestToEureka(int invId);
}
