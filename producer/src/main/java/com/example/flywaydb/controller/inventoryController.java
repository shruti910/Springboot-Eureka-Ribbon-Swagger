package com.example.flywaydb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flywaydb.Inventory;
import com.example.flywaydb.service.InventoryService;
import com.example.flywaydb.repository.InventoryRepository; 
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class inventoryController {
    
    @Autowired 
            private InventoryService invService;    
   
    InventoryRepository invrep;
    
    
// @RequestMapping(value="/", method = RequestMethod.GET)
//    public @ResponseBody String  showLandingPage(){
//        return "list of items in inventory";
//    }
    
   //   @RequestMapping("/api")
    @GetMapping(value = "/api/")
	public List<Inventory> getAllInventoryInfo() {
		return invService.getAllInventoryInfo();
	}

    @GetMapping(value = "/api/{prodId}")
	public Inventory getInvByInvId(@PathVariable("prodId") String pId) {
           int p= Integer.parseInt(pId);
		return invService.getInvByInvId(p);
	}
        
    @PostMapping(value = "/api/create")
	public Inventory addInventory(@RequestBody Inventory inv) {
		return invService.addInventory(inv);
	}
        
        
    @PutMapping(value = "/api/update/{prodId}")
	public Inventory updateInventory(@RequestBody Inventory inv, @PathVariable("prodId")String pId) {
             int p= Integer.parseInt(pId);
		return invService.updateInventory(inv, p);
	}
        
        
    @DeleteMapping(value = "/api/delete/{prodId}")
	public void deleteById(@PathVariable(value = "prodId") String pId) {
              int p= Integer.parseInt(pId);
		invService.deleteById(p);
	}
        
        @RequestMapping("/api/test")
public String savetable(){
    invrep.save(new Inventory( 10,"vodka","drinks",4500.00));
    return "success";
}
}
