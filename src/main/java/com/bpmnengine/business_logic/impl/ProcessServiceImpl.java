package com.bpmnengine.business_logic.impl;

import com.bpmnengine.business_logic.ProcessService;
import com.bpmnengine.presentation.dto.AssociationDto;
import com.bpmnengine.presentation.dto.DeploymentDto;
import com.bpmnengine.presentation.dto.ProcessDefinitionDto;
import com.bpmnengine.presentation.dto.ProcessInstanceDto;
import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.repository.DeploymentBuilder;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.repository.ProcessDefinitionQuery;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    RepositoryService repositoryService;
    @Autowired
    FormService formService;
    @Autowired
    TaskService taskService;
    @Override
    public List<ProcessDefinitionDto> getProcesses(String processDefinitionId) {
        List<ProcessDefinitionDto> processesRetrieved= new ArrayList<>();
        try{
            ProcessDefinitionQuery query;
            query=repositoryService.createProcessDefinitionQuery().active();
            if(processDefinitionId!=null)
                query.processDefinitionId(processDefinitionId);
            for(ProcessDefinition processDefinition : query.list())
                processesRetrieved.add(ProcessDefinitionDto.setDataFromProcessDefinition(processDefinition));

        }catch (Exception e){
            e.printStackTrace();
        }
        return processesRetrieved;
    }

    @Override
    public DeploymentDto deployProcess(MultipartFile file, String deploymentName) {
        DeploymentDto deployment = new DeploymentDto();
        try{

            if(file.isEmpty() || file !=null) {
                DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
                if (deploymentName!=null)
                    deploymentBuilder.name(deploymentName);
                deploymentBuilder.addInputStream(file.getOriginalFilename(),new ByteArrayInputStream(file.getBytes()));
               deployment=DeploymentDto.setDataFromDeployment(deploymentBuilder.deploy());
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return deployment;
    }

    @Override
    public ProcessInstanceDto startProcess(String processDefinitionId, Map<String,Object> params){
        ProcessInstance instance;
        Task task;
        if(repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult()!=null){
            String startFormKey=formService.getStartFormKey(processDefinitionId);
            Map<String,Object> insideMap;
            if(startFormKey!=null || !startFormKey.isEmpty()) {
                if (params.containsKey("content")) {
                    insideMap = (Map) (params.get("content"));
                    Map.Entry<String, Object> entry = insideMap.entrySet().iterator().next();
                    instance = formService.submitStartForm(processDefinitionId, (Map) entry.getValue());
                } else
                    instance = formService.submitStartForm(processDefinitionId, params);
            }else
                instance=formService.submitStartForm(processDefinitionId,null);
            task= taskService.createTaskQuery().processInstanceId(instance.getId()).initializeFormKeys().singleResult();
            return ProcessInstanceDto.setDataFromInstance(instance,task);
        }
        else
//            throw new Exception();
        return null;


    }

    @Override
    public ProcessDefinitionDto suspendProcess(String processDefinitionId) {
        return null;
    }

    @Override
    public AssociationDto getStartForm(String processDefinitionId) {
        AssociationDto associationDto =  new AssociationDto();


        return null;
    }
}
