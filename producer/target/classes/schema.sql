/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: Sep 4, 2020
 */
--CREATE SCHEMA IF NOT EXISTS InventorySchema;

DROP TABLE IF EXISTS Inventories;
 
CREATE TABLE Inventories (
  id INT  PRIMARY KEY,
  product_name VARCHAR(255) NOT NULL,
  product_category VARCHAR(255) NOT NULL,
  fare  DOUBLE
);

-- Insert into Inventories(id,product_name,product_category,fare) values(1, 'maaza','beverages',23.5);
-- Insert into Inventories(id,product_name,product_category,fare) values(2, 'pepsi','beverages',50.0);
-- Insert into Inventories(id,product_name,product_category,fare) values(3, 'kurkure','snacks',45.0);
