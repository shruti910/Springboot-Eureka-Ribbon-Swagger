package com.example.flywaydb;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class InventoryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementApplication.class, args);
	}
   @Bean     
        public Docket swaggerConfiguration(){
        
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                   // .paths(PathSelectors.ant("/api/*"))
              //      .apis(RequesthandlerSelectors.basePackage("com.example.flywaydb.controller"))
                     .paths(PathSelectors.any())
                     .apis(RequestHandlerSelectors.any())              
         
                    .build()
                    .apiInfo(apiDetails());
            
        }
        private ApiInfo apiDetails() {
    return new ApiInfo(
      "My producer REST API", 
      "API registered on Eureka with H2 database.", 
      "1.0", 
      "Terms of service", 
      new Contact("Shruti Prajapati", "www.example.com", "myeaddress@company.com"), 
      "License of API", "www.example.com", Collections.emptyList());
}
}
