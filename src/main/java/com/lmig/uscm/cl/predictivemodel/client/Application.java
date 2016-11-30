package com.lmig.uscm.cl.predictivemodel.client;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.lmig.uscm.cl.predictivemodel.client.storage.StorageProperties;
import com.lmig.uscm.cl.predictivemodel.client.storage.StorageService;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application 
		//implements CommandLineRunner
	{

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private CoefficientRepository coefficientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
            storageService.deleteAll();
            storageService.init();
		};
	}
	
	
	/*
	@Override
	public void run(String... args) throws Exception {
		
		//coefficientRepository.deleteAll();
		
		Coefficient coefficient = new Coefficient();
		coefficient.setDate(new Date());
		coefficient.setName("CoefficientNew");
		coefficient.setPath("/json/APD_Subro_Model_Coefficients");
		
		Coefficient coefficient2 = new Coefficient();
		coefficient2.setDate(new Date());
		coefficient2.setName("CoefficientNew2");
		coefficient2.setPath("/json/APD_Subro_Model_CoefficientsNew");
		
		coefficientRepository.save(coefficient);

		coefficientRepository.save(coefficient2);
		for (Coefficient coeff : coefficientRepository.findAll()) {
			System.out.println(coeff);
		}
		

//		repository.deleteAll();

		// save a couple of customers
//		repository.save(new Customer("Alice", "Smith"));
//		repository.save(new Customer("Bob", "Smith"));
//
//		// fetch all customers
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (Customer customer : repository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();
//
//		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(repository.findByFirstName("Alice"));
//
//		System.out.println("Customers found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
//		for (Customer customer : repository.findByLastName("Smith")) {
//			System.out.println(customer);
//		}
		System.out.println("Hello World in Spring boot");
	}
	*/
}
