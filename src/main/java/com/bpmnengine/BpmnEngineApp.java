package com.bpmnengine;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableProcessApplication
public class BpmnEngineApp extends SpringBootServletInitializer
{


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BpmnEngineApp.class);
    }
    public static void main( String[] args ) throws Exception
    {
        SpringApplication.run(BpmnEngineApp.class,args);
    }


}
