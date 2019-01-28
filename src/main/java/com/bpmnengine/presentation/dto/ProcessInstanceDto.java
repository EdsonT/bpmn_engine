package com.bpmnengine.presentation.dto;

import org.camunda.bpm.engine.BadUserRequestException;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;

public class ProcessInstanceDto {
    protected String processInstanceId;
    protected String processDefinitionId;
    protected TaskDto nextStep;
    public ProcessInstanceDto(){
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public TaskDto getNextStep() {
        return nextStep;
    }

    public static ProcessInstanceDto setDataFromInstance(ProcessInstance processInstance,Task task){
        ProcessInstanceDto dto= new ProcessInstanceDto();
            dto.processInstanceId=processInstance.getId();
            dto.processDefinitionId=processInstance.getProcessDefinitionId();
            try{
                dto.nextStep =TaskDto.setDataFromDefinition(task);}
            catch(BadUserRequestException e){

            }
        return dto;

    }
}
