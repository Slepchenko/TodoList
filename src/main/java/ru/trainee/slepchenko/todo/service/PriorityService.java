package ru.trainee.slepchenko.todo.service;



import ru.trainee.slepchenko.todo.model.Priority;

import java.util.List;
import java.util.Optional;

public interface PriorityService {

    List<Priority> findAll();

    Optional<Priority> findPriorityByName(String name);

}
