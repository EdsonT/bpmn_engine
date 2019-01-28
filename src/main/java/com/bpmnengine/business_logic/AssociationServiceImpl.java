package com.bpmnengine.business_logic;

import com.bpmnengine.presentation.dto.AssociationDto;
import org.camunda.bpm.engine.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociationServiceImpl {

    @Autowired
    FormService formService;

    public AssociationDto getStartForm(String processDefinitionId){
        AssociationDto associationDto = new AssociationDto();
        if(processDefinitionId!=null || !processDefinitionId.isEmpty())
            associationDto.setFormCode(formService.getStartFormKey(processDefinitionId).toString());
        return associationDto;

    }
}
