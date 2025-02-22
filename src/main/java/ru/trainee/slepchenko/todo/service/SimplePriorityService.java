package ru.trainee.slepchenko.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trainee.slepchenko.todo.model.Priority;
import ru.trainee.slepchenko.todo.repository.PriorityRepository;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimplePriorityService implements PriorityService {

    private final PriorityRepository priorityRepository;

    @Override
    public List<Priority> findAll() {
        return priorityRepository.findAll();
    }

    @Override
    public Optional<Priority> findPriorityByName(String name) {
        return priorityRepository.findPriorityByName(name);
    }

}
