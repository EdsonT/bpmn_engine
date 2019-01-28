package com.bpmnengine.presentation.dto;

import com.bpmnengine.persistence.domain.Hierarchy;

public class HierarchyDto {
    protected String code;
    protected String name;
    protected String subHierarchy;

    public HierarchyDto(){}
    public HierarchyDto(String code,
                        String name,
                        String subHierarchy){
        this.code=code;
        this.name=name;
        this.subHierarchy=subHierarchy;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubHierarchy() {
        return subHierarchy;
    }

    public void setSubHierarchy(String subHierarchy) {
        this.subHierarchy = subHierarchy;
    }

    public static HierarchyDto setDataFromHierarchy(Hierarchy hierarchy){
        HierarchyDto dto = new HierarchyDto();
        dto.code=hierarchy.getCode();
        dto.name=hierarchy.getName();
        if(hierarchy.getSubHierarchy()!=null)
            dto.subHierarchy=hierarchy.getSubHierarchy().getCode();
        return dto;
    }
}
