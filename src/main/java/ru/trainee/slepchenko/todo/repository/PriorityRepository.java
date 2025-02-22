package ru.trainee.slepchenko.todo.repository;

import ru.trainee.slepchenko.todo.model.Priority;

import java.util.List;
import java.util.Optional;

public interface PriorityRepository {

    List<Priority> findAll();

    Optional<Priority> findPriorityByName(String name);

}
