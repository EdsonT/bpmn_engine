package com.bpmnengine.presentation.web;

import com.bpmnengine.business_logic.HierarchyService;
import com.bpmnengine.presentation.dto.HierarchyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("hierarchy")
@RestController
public class HierarchyController {

    @Autowired
    HierarchyService hierarchyService;

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public HierarchyDto create(@RequestBody HierarchyDto body){
        return hierarchyService.createHierarchy(body);

    }


}
