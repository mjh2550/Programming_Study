package com.daea.daeainfosys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//exclude={DataSourceAutoConfiguration.class} 는 db연결시 제거해야 함
@SpringBootApplication
public class DaeainfosysApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaeainfosysApplication.class, args);


			}

}
