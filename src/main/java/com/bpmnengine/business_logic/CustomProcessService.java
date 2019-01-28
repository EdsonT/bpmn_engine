package com.bpmnengine.business_logic;

import com.bpmnengine.presentation.dto.DeploymentDto;
import com.bpmnengine.presentation.dto.ProcessDefinitionDto;
import com.bpmnengine.presentation.dto.ProcessInstanceDto;
import jdk.nashorn.internal.ir.WhileNode;
import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.form.StartFormData;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.repository.ProcessDefinitionQuery;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class CustomProcessService {

    @Autowired
    RepositoryService repositoryService;
    @Autowired
    FormService formService;
    @Autowired
    TaskService taskService;

    /**
     * Create a process instance of the process definition provided
     * @param processId
     * @return
     */
    public ProcessInstanceDto startProcess(String processId, Map<String, Object> params) throws JSONException{
        ProcessDefinition definition=repositoryService.createProcessDefinitionQuery()
                                                      .processDefinitionId(processId)
                                                      .singleResult();


        StartFormData formData = formService.getStartFormData(definition.getId());
        ProcessInstance instance;
        String startFormKey=formService.getStartFormKey(definition.getId());
        Map<String,Object> insideMap;
        if (startFormKey!=null){
            if(params.containsKey("content"))
            {
                insideMap=(Map)(params.get("content"));
                Map.Entry<String,Object> entry=insideMap.entrySet().iterator().next();

                instance= formService.submitStartForm(definition.getId(),(Map)entry.getValue());
                System.out.println((Map)entry.getValue());
            }
            else
            instance = formService.submitStartForm(definition.getId(),params);
        }else{
            instance = formService.submitStartForm(definition.getId(),params);
        }
        Task task=taskService.createTaskQuery().processInstanceId(instance.getId()).initializeFormKeys().singleResult();

        return ProcessInstanceDto.setDataFromInstance(instance,task);
    }

}
