package com.chryl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.chryl.admin.mapper.common")
public class VueAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueAdminApplication.class, args);
	}

}
