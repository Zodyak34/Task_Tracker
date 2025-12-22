package com.zodyak.tasks.mappers;

import com.zodyak.tasks.domain.dto.TaskDto;
import com.zodyak.tasks.domain.entities.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
