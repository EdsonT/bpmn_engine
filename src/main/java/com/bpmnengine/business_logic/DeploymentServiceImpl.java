package com.bpmnengine.business_logic;

import com.bpmnengine.presentation.dto.DeploymentDto;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.DeploymentBuilder;
import org.camunda.bpm.engine.rest.mapper.MultipartFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DeploymentServiceImpl {
    @Autowired
    RepositoryService repositoryService;

    protected static final Set<String> RESERVED_KEYWORDS = new HashSet<String>();
    public final static String DEPLOYMENT_NAME = "deployment-name";
    public final static String DEPLOYMENT_SOURCE="deployment-source";
    public final static String DEPLOYMENT_DATA="data";

    static{
        RESERVED_KEYWORDS.add(DEPLOYMENT_NAME);
        RESERVED_KEYWORDS.add(DEPLOYMENT_SOURCE);
        RESERVED_KEYWORDS.add(DEPLOYMENT_DATA);
    }

    public DeploymentDto createDeployment(MultipartFormData payload){
        DeploymentBuilder deploymentBuilder = extractDeploymentInformation(payload);
        DeploymentDto deployment= new DeploymentDto();
        return deployment;
    }
    public DeploymentBuilder extractDeploymentInformation(MultipartFormData payload){
        DeploymentBuilder deploymentBuilder=repositoryService.createDeployment();
        String deploymentName = payload.getNamedPart(DEPLOYMENT_NAME).getTextContent();
//        if(payload.getNamedPart(DEPLOYMENT_NAME)!=null)
//            deploymentBuilder.name()
        return deploymentBuilder;
    }

}
