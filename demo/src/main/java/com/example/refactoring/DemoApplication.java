package com.example.refactoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.refactoring.DeliveryDate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DeliveryDate.class, args);
		var deliveryDate = new DeliveryDate();
		System.out.print(deliveryDate.getDeliveryDate());
//		System.out.print("hello world");
	}

}
