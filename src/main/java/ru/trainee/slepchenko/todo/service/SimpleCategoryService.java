package ru.trainee.slepchenko.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trainee.slepchenko.todo.model.Category;
import ru.trainee.slepchenko.todo.repository.CategoryRepository;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SimpleCategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findNecessaryCategories(String[] categoryIds) {
        return categoryRepository.findNecessaryCategories(Arrays.stream(categoryIds).map(Integer::valueOf).toList());
    }

    @Override
    public Optional<Category> findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    public Optional<Category> findCategoryById(int id) {
        return categoryRepository.findCategoryById(id);
    }
}
