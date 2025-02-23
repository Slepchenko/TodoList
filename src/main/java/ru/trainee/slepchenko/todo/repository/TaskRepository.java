package ru.trainee.slepchenko.todo.repository;

import ru.trainee.slepchenko.todo.model.Task;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface TaskRepository {

    Optional<Task> findById(int id);

    Collection<Task> findAll();

    Collection<Task> findByDateAndStatus(LocalDate startDate, LocalDate endDate, boolean done);

    Task save(Task task);

    boolean deleteById(int id);

    boolean update(Task task);

    boolean changeStatus(int id, boolean status);
}
