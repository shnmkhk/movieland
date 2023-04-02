package com.rabbit.mdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mysql.cj.PerConnectionLRUFactory;

@NativeHint(types = {
		@TypeHint(types = {
				PerConnectionLRUFactory.class
		})
})
@SpringBootApplication
public class LiquibaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiquibaseApplication.class, args);
	}
}
