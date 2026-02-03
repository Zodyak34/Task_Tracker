package com.zodyak.tasks.controllers;

import com.zodyak.tasks.domain.dto.TaskDto;
import com.zodyak.tasks.domain.entities.Task;
import com.zodyak.tasks.mappers.TaskMapper;
import com.zodyak.tasks.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists/{task_list_id}/tasks")
public class TaskController {

    private final TaskService taskService;

    private final TaskMapper taskMapper;


    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TaskDto> listTasks(
            @PathVariable("task_list_id") UUID taskListId
    ){
        return taskService.listTasks(taskListId)
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @PostMapping
    public TaskDto createTask(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskDto taskDto
    ){
        Task createdTask = taskService.createTask(
                taskListId,
                taskMapper.fromDto(taskDto)
        );

        return taskMapper.toDto(createdTask);
    }
}
