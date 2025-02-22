package ru.trainee.slepchenko.todo.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.trainee.slepchenko.todo.model.Task;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TaskRepositoryHbn implements TaskRepository {

    private final CrudRepository crudRepository;

    @Override
    public Optional<Task> findById(int id) {
        return crudRepository.optional(
                "from Task t "
                        + "join fetch t.categories "
                        + "join fetch t.priority where t.id = :fId",
                Task.class,
                Map.of("fId", id)
        );
    }

    @Override
    public Collection<Task> findAll() {
        return crudRepository.query(
                "select distinct t from Task t "
                        + "join fetch t.priority "
                        + "join fetch t.categories "
                        + "order by t.priority.id, created desc",
                Task.class
        );
    }

    @Transactional
    @Override
    public Collection<Task> findDone() {
        return crudRepository.query(
                "select distinct t from Task t "
                        + "join fetch t.priority "
                        + "join fetch t.categories where done = true order by t.priority.id, created desc",
                Task.class
        );
    }

    @Override
    public Collection<Task> findNew() {
        return crudRepository.query(
                "select distinct t from Task t "
                        + "join fetch t.priority "
                        + "join fetch t.categories where t.done = false order by t.priority.id, created desc",
                Task.class
        );
    }

    @Override
    public Task save(Task task) {
        crudRepository.run(session -> session.persist(task));
        return task;
    }

    @Override
    public boolean deleteById(int id) {
        return crudRepository.query(
                "delete from Task where id = :fId",
                Map.of("fId", id)
        );
    }

    @Override
    public boolean update(Task task) {
        return crudRepository.query(
                "update from Task set name = :fName, description = :fDescription, priority = :fPriority where id = :fId",
                Map.of("fName",
                        task.getName(),
                        "fDescription",
                        task.getDescription(),
                        "fId", task.getId(), "fPriority", task.getPriority())
        );
    }

    @Override
    public boolean changeStatusToTrue(int id) {
        return crudRepository.query(
                "update from Task set done = true where id = :fId",
                Map.of("fId", id)
        );
    }

}
