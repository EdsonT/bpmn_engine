package com.bpmnengine.business_logic;


import com.bpmnengine.presentation.dto.AssociationDto;
import com.bpmnengine.presentation.dto.DeploymentDto;
import com.bpmnengine.presentation.dto.ProcessDefinitionDto;
import com.bpmnengine.presentation.dto.ProcessInstanceDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public interface ProcessService {
    /**
     * Obtains a number of processes by following the provided search criteria
     * @param processDefinitionId
     * @return
     */
    List<ProcessDefinitionDto> getProcesses(String processDefinitionId);

    /**
     * Creates a process deployment along with a process definition from the given file
     * @param file
     * @param deploymentName
     * @return
     */
    DeploymentDto deployProcess(MultipartFile file, String deploymentName);

    /**
     * Creates a process instance  from a provided process definition
     * @param processDefinitionId
     * @param params
     * @return
     */
    ProcessInstanceDto startProcess(String processDefinitionId, Map<String,Object> params) throws Exception;
    ProcessDefinitionDto suspendProcess(String processDefinitionId);
    AssociationDto getStartForm(String processDefinitionId);

}
