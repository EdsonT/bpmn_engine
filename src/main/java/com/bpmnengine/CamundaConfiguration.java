package com.bpmnengine;

import org.camunda.connect.plugin.impl.ConnectProcessEnginePlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaConfiguration {
    @Bean
    public ConnectProcessEnginePlugin connectProcessEnginePlugin(){
        return new ConnectProcessEnginePlugin();
    }

}
