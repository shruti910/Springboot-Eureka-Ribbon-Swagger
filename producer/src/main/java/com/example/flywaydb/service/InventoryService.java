package com.example.flywaydb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flywaydb.Inventory;

import com.example.flywaydb.repository.InventoryRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
	private InventoryRepository invRepository;

    public Inventory addInventory(Inventory inv) {
		Inventory newinv= new Inventory();
		newinv.setProduct_Id(inv.getProduct_Id());
		newinv.setProduct_Name(inv.getProduct_Name());
                newinv.setProduct_Category(inv.getProduct_Category());
                newinv.setFare(inv.getFare());
	    return invRepository.save(newinv);
	}

    public Inventory updateInventory(Inventory inv, int invId) {
		
                 Inventory newinv=new Inventory();
		 Optional<Inventory> upinv = invRepository.findById(invId);
                 if(upinv.isPresent()) {
                   newinv =upinv.get();
                     
                     newinv.setProduct_Name(inv.getProduct_Name());
                    newinv.setProduct_Category(inv.getProduct_Category());
                     newinv.setFare(inv.getFare());
                        
		 }
       
       return invRepository.save(newinv);
		
	}
    
    public void deleteById(int invId) {
		invRepository.deleteById(invId);
	}
    
    
    public Inventory getInvByInvId(int invId) { 
		  Optional<Inventory> inv = invRepository.findById(invId);   
		  return inv.get();
	  }
    
    public List<Inventory> getAllInventoryInfo() {
//		List<Inventory> invList = Arrays.asList(
//				new Inventory(1, "maaza","beverages",23.5),
//				new Inventory(2, "pepsi","beverages",50.0));
//		invRepository.saveAll(invList);
		List<Inventory> invDataList = new ArrayList<>();
                for(Inventory i :  invRepository.findAll()){
                invDataList.add(i);
                }
                       
		//return invDataList.stream().map(converterService::convertToDto).collect(Collectors.toList());
                return invDataList;
	}
    
   

 
}

    




