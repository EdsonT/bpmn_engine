package com.bpmnengine.presentation.dto;

import org.camunda.bpm.engine.repository.ProcessDefinition;

public class ProcessDefinitionDto {
    private String id;
    private String key;
    private String category;
    private String description;
    private String name;
    private int version;
    private String resource;
    private String deploymentId;

    public ProcessDefinitionDto(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {

        this.deploymentId = deploymentId;
    }
    public static ProcessDefinitionDto setDataFromProcessDefinition(ProcessDefinition definition){
        ProcessDefinitionDto dto = new ProcessDefinitionDto();
        dto.id=definition.getId();
        dto.key=definition.getKey();
        dto.category=definition.getCategory();
        dto.description=definition.getDescription();
        dto.name=definition.getName();
        dto.version=definition.getVersion();
        dto.resource=definition.getResourceName();
        dto.deploymentId=definition.getDeploymentId();
        return dto;
    }
}
