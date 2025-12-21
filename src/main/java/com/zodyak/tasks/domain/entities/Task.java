package com.zodyak.tasks.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {
    //Declare Variables
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) //Generate ID if task is created with a null ID
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false) //Default for updateable is true so it is left out
    private String title;

    @Column(name = "description") //Default for nullable is true so it is left out
    private String description;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "statues", nullable = false)
    private TaskStatus status;

    @Column(name = "priority", nullable = false)
    private TaskPriority priority;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;
    //End Variables

    //Constructors
    public Task() {
    }

    public Task(UUID id, LocalDateTime dueDate, String title, String description, TaskStatus status, TaskPriority priority, LocalDateTime created, LocalDateTime updated) {
        this.dueDate = dueDate;
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.created = created;
        this.updated = updated;
    }
    //End Constructors

    //Getters
    public LocalDateTime getUpdated() {
        return updated;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public UUID getId() {
        return id;
    }
    //End Getters

    //Setters
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
    //End Setters

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(dueDate, task.dueDate) && status == task.status && priority == task.priority && Objects.equals(created, task.created) && Objects.equals(updated, task.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate, status, priority, created, updated);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", priority=" + priority +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
