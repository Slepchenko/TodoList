package ru.trainee.slepchenko.todo.service;



import ru.trainee.slepchenko.todo.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    List<Category> findNecessaryCategories(String[] categoryIds);

    Optional<Category> findCategoryByName(String name);

    Optional<Category> findCategoryById(int id);

}
