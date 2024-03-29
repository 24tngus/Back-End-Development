package com.mission.mymission;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyMissionApplication {

	public static void main(String[] args) {

		// SpringApplication.run(MySpringBoot3Application.class, args);
		SpringApplication application = new SpringApplication(MyMissionApplication.class);
		// WebApplication Type을 변경하기 위한 목적
		application.setWebApplicationType(WebApplicationType.SERVLET);
		// None : 더이상 WebApplication이 아님
		application.run(args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
}
