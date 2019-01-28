package com.bpmnengine.persistence.repository;

import com.bpmnengine.persistence.domain.Hierarchy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;


public interface HierarchyRepository extends CrudRepository<Hierarchy, String> {

    @Query(value="SELECT * FROM ssi_hierarchy h WHERE h.code = ?1", nativeQuery = true)
    Hierarchy findByCode(String code);

    List<Hierarchy> findAll();
}
