package com.bpmnengine.persistence.domain;

import org.camunda.bpm.model.bpmn.instance.Process;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ssi_hierarchy")
public class Hierarchy extends BaseEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sub_hierarchy")
    private Hierarchy subHierarchy;


    public Hierarchy getSubHierarchy() {
        return subHierarchy;
    }

    public void setSubHierarchy(Hierarchy subHierarchy) {
        this.subHierarchy = subHierarchy;
    }
}
