package com.bpmnengine.presentation.dto;

import org.camunda.bpm.engine.repository.Deployment;

import java.util.Date;

public class DeploymentDto {
    protected String id;
    protected String name;
    protected String source;
    protected Date deploymentTime;
    public DeploymentDto(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getDeploymentTime() {
        return deploymentTime;
    }

    public void setDeploymentTime(Date deploymentTime) {
        this.deploymentTime = deploymentTime;
    }
    public static DeploymentDto setDataFromDeployment(Deployment deployment){
        DeploymentDto dto = new DeploymentDto();
        dto.id=deployment.getId();
        dto.name=deployment.getName();
        dto.source=deployment.getSource();
        dto.deploymentTime=deployment.getDeploymentTime();
        return dto;
    }

}
