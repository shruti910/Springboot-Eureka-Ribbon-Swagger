package com.example.flywaydb;

import java.io.Serializable;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Inventories")
public class Inventory implements Serializable {
	
	@Column(name="id")
	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private int product_Id;
	@Column(name="product_name")
	private String product_Name;
	@Column(name="product_category")
	private String product_Category;
       @Column(name="fare")
	private double fare;

	public String getProduct_Category() {
		return product_Category;
	}
	public void setProduct_Category(String product_Category) {
		this.product_Category = product_Category;
	}
	
	
	public int getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public Inventory() {
		super();
	}
	public Inventory(int product_Id, String product_Name, String product_Category, double fare) {
		super();
		this.product_Id = product_Id;
		this.product_Name = product_Name;
		this.product_Category = product_Category;
		this.fare = fare;
		
	}

}
