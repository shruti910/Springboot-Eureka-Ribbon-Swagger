package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.service.consumerService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class inventorycontroller {

	@Autowired
	private consumerService cService;
       
        @PostMapping(value = "/create")
	public ResponseEntity<HttpStatus> addInventory(@RequestBody Inventory inv) {
		cService.addInventory(inv);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	public List<Inventory> getAllInventoryInfo() {
		return cService.getAllInventoryInfo();
	}
	
	@PutMapping(value = "/update/{pId}")
	public ResponseEntity<HttpStatus> updateInventory(@RequestBody Inventory inv, @PathVariable("pId") String pId) {
             int p= Integer.parseInt(pId);
		cService.updateInventory(inv, p);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/{pId}")
	public Inventory getInventoryByinvId(@PathVariable("pId") String pId) {
            int p= Integer.parseInt(pId);
		return cService.getInventoryByinvId(p);
	}
	
	@DeleteMapping(value = "/delete/{pId}")
	public void deleteById(@PathVariable(value = "pId") String pId) {
             int p= Integer.parseInt(pId);
		cService.deleteById(p);
	}
	
	
}