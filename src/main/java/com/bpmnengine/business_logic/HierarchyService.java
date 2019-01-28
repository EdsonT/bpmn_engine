package com.bpmnengine.business_logic;

import com.bpmnengine.persistence.domain.Hierarchy;
import com.bpmnengine.persistence.repository.HierarchyRepository;
import com.bpmnengine.presentation.dto.HierarchyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface HierarchyService {

    HierarchyDto createHierarchy(HierarchyDto params);
}
