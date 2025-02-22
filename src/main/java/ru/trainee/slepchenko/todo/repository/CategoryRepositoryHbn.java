package ru.trainee.slepchenko.todo.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.trainee.slepchenko.todo.model.Category;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class CategoryRepositoryHbn implements CategoryRepository {

    private final CrudRepository crudRepository;

    @Override
    public List<Category> findAll() {
        return crudRepository.query("from Category", Category.class);
    }

    @Override
    public List<Category> findNecessaryCategories(List<Integer> ids) {
        return crudRepository.query(
                "from Category c where c.id in (:ids)",
                Category.class,
                Map.of("ids", ids)
        );
    }

    @Override
    public Optional<Category> findCategoryByName(String name) {
        return crudRepository.optional(
                "from Category where name = :fName",
                Category.class,
                Map.of("fName", name));
    }

    @Override
    public Optional<Category> findCategoryById(int id) {
        return crudRepository.optional(
                "from Category where id = :fId",
                Category.class,
                Map.of("fId", id)
        );
    }
}
