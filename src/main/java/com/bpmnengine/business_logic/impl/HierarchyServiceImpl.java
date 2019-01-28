package com.bpmnengine.business_logic.impl;

import com.bpmnengine.business_logic.HierarchyService;
import com.bpmnengine.persistence.domain.Hierarchy;
import com.bpmnengine.persistence.repository.HierarchyRepository;
import com.bpmnengine.presentation.dto.HierarchyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class HierarchyServiceImpl implements HierarchyService {
    @Autowired
    HierarchyRepository hierarchyRepository;
    @Override
    public HierarchyDto createHierarchy(HierarchyDto params) {
        Hierarchy hierarchy=new Hierarchy();
        hierarchy.setCode(UUID.randomUUID().toString());
        hierarchy.setName(params.getName());
        if (params.getSubHierarchy() != null){
            hierarchy.setSubHierarchy(hierarchyRepository.findByCode(params.getSubHierarchy()));
        }
        hierarchyRepository.save(hierarchy);
        return HierarchyDto.setDataFromHierarchy(hierarchy);
    }
}
