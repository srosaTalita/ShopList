package com.app.shoplist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.app.shoplist")
public class ShoplistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoplistApplication.class, args);
	}

}
