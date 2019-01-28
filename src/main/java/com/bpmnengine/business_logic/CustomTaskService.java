package com.bpmnengine.business_logic;

import com.bpmnengine.presentation.dto.TaskDto;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.task.TaskQuery;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomTaskService {
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    TaskService taskService;
    @Autowired
    RuntimeService runtimeService;

    /**
     * This retrieves tha tasks according to the provided criteria
     * @param processId
     * @param taskId
     * @return
     */

    public List<TaskDto> getTasks(String processId, String taskId){
        List<TaskDto> taskList= new ArrayList<>();

        TaskQuery taskQuery= taskService.createTaskQuery().active();
        taskQuery.initializeFormKeys();
        List<Task> tasks=taskQuery.list();
        for (Task task:tasks) {
            taskList.add(TaskDto.setDataFromDefinition(task));
        }
    return taskList;
    }

    /**
     * This should validate that the parameter given is a valid task and complete it.
     * @param taskId
     */
    public void completeTask(String taskId, JSONObject params){
        Task task=taskService.createTaskQuery().taskId(taskId).singleResult();

        if(!task.isSuspended() || task != null)
            taskService.complete(taskId);
    }
}
