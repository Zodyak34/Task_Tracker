package com.zodyak.tasks.mappers;

import com.zodyak.tasks.domain.dto.TaskListDto;
import com.zodyak.tasks.domain.entities.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
