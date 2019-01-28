package com.bpmnengine.presentation.web;

import com.bpmnengine.business_logic.CustomTaskService;
import com.bpmnengine.presentation.dto.TaskDto;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("task")
@RestController
public class TaskController {
    @Autowired
    CustomTaskService taskService;
    @RequestMapping(value="",method = RequestMethod.GET)
    public @ResponseBody
    List<TaskDto> getTasks(){
        return taskService.getTasks(null,null);
    }
    @RequestMapping(value="/{taskId}/complete", method = RequestMethod.POST)
    public Object completeTask(@PathVariable("taskId") String taskId, @RequestBody JSONObject params){
        taskService.completeTask(taskId, params);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
