package org.binggo.mockapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class MockApp extends SpringBootServletInitializer {
	
	private static final Logger logger = LoggerFactory.getLogger(MockApp.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MockApp.class);
	}

    public static void main( String[] args )
    {
		//SpringApplication app = new SpringApplication(MockApp.class);
		//app.run(args);
    	SpringApplication.run(MockApp.class, args);
		
		logger.info("start mockapp successfully.");
    }
}
