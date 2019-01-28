package com.bpmnengine.business_logic;

import com.bpmnengine.presentation.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<TaskDto> getTasks(String processInstance);
    TaskDto completeTask(String taskId);

}
