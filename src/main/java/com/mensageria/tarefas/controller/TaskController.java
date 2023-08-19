package com.mensageria.tarefas.controller;

import com.mensageria.tarefas.model.Task;
import com.mensageria.tarefas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Task crateTask(@RequestBody Task task){
        return service.createTasks(task);
    }

    @GetMapping("/find-task")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks(){
        return service.listAllTask();
    }

    @GetMapping("/find-task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") long id){
        return service.findTaskById(id);
    }

    @PutMapping("/update-task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTaskById(@PathVariable (value = "id") Long id, @RequestBody Task task) {
        return service.updateTask(task,id);
    }

    @DeleteMapping("/delete-task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") Long id){
        return service.deleteById(id);
    }
}
