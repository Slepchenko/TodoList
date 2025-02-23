package ru.trainee.slepchenko.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trainee.slepchenko.todo.model.Task;
import ru.trainee.slepchenko.todo.repository.TaskRepository;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SimpleTaskService implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Optional<Task> findById(int id) {
        return taskRepository.findById(id);
    }

    @Override
    public Collection<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Collection<Task> findByDateAndStatus(LocalDate startDate, LocalDate endDate, boolean done) {
        return taskRepository.findByDateAndStatus(startDate, endDate, done);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public boolean delete(int id) {
        return taskRepository.deleteById(id);
    }

    @Override
    public boolean update(Task task) {
        return taskRepository.update(task);
    }

    @Override
    public boolean changeStatus(int id, boolean status) {

        return taskRepository.changeStatus(id, status);
    }

}
