package com.bpmnengine.presentation.dto;

import org.camunda.bpm.engine.BadUserRequestException;
import org.camunda.bpm.engine.task.Task;

public class TaskDto {
    protected String id;
    protected String name;
    protected String assignee;
    protected String created;
    protected String processDefinitionId;
    protected String processInstanceId;
    protected String formCode;
    public TaskDto(){

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getCreated() {
        return created;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public String getFormCode(){return formCode;}

    public static TaskDto setDataFromDefinition(Task task){
        TaskDto dto = new TaskDto();
        if(task!=null){
            dto.id=task.getId();
            dto.name=task.getName();
            dto.assignee=task.getAssignee();
            dto.created=task.getCreateTime().toString();
            dto.processDefinitionId=task.getProcessDefinitionId();
            dto.processInstanceId=task.getProcessInstanceId();
            try {
                dto.formCode = task.getFormKey();
            }
            catch (BadUserRequestException e){

            }
        }
        return dto;
    }
}
