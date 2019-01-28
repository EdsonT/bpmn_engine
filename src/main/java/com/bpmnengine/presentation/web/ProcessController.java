package com.bpmnengine.presentation.web;

import com.bpmnengine.business_logic.AssociationServiceImpl;
import com.bpmnengine.business_logic.CustomProcessService;
import com.bpmnengine.business_logic.ProcessService;
import com.bpmnengine.presentation.dto.AssociationDto;
import com.bpmnengine.presentation.dto.DeploymentDto;
import com.bpmnengine.presentation.dto.ProcessDefinitionDto;
import com.bpmnengine.presentation.dto.ProcessInstanceDto;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequestMapping("process-definition")
@RestController
public class ProcessController{
    @Autowired
    CustomProcessService customProcessService;
    @Autowired
    AssociationServiceImpl associationServiceImpl;
    @Autowired
    ProcessService processService;

    @RequestMapping(value ="/{code}",method = RequestMethod.GET)
    public @ResponseBody
    List<ProcessDefinitionDto> getProcess(@PathVariable(value = "code",required = false) String code) {
        System.out.println(code);
        return processService.getProcesses(code);
    }
    @RequestMapping(value ="",method = RequestMethod.GET)
    public @ResponseBody
    List<ProcessDefinitionDto> getAll() {
        return processService.getProcesses(null);
    }

    @RequestMapping(value = "/deploy", method = RequestMethod.POST)
    public DeploymentDto deploy(@RequestParam("file") MultipartFile file,@RequestParam(value = "name", required = false) String deploymentName) throws IOException{
        return processService.deployProcess(file,deploymentName);
    }

    @RequestMapping(value = "{code}/start",method = RequestMethod.POST)
    public @ResponseBody
    ProcessInstanceDto start(@PathVariable("code") String code, @RequestBody Map<String,Object> params) throws JSONException{
//        System.out.println(params);
        return customProcessService.startProcess(code,params);
    }


    @RequestMapping(value="/{code}/init",method = RequestMethod.GET)
    public AssociationDto getStartForm(@PathVariable("code") String processDefinitionId)
    {
        return associationServiceImpl.getStartForm(processDefinitionId);
    }



}
