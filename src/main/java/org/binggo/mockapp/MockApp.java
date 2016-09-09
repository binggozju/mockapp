package org.binggo.mockapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("org.binggo.mockapp.mapper")
public class MockApp 
{
	private static final Logger logger = LoggerFactory.getLogger(MockApp.class);
	
    public static void main( String[] args )
    {
		SpringApplication app = new SpringApplication(MockApp.class);
		app.run(args);
		
		logger.info("start mockapp successfully.");
    }
}
