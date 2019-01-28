package com.bpmnengine.business_logic.impl;

import com.bpmnengine.business_logic.TaskService;
import com.bpmnengine.presentation.dto.TaskDto;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    @Override
    public List<TaskDto> getTasks(String processDefinitionId) {
        return null;
    }

    @Override
    public TaskDto completeTask(String taskId) {
        return null;
    }

}
