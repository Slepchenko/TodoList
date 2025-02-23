package ru.trainee.slepchenko.todo.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.trainee.slepchenko.todo.model.Task;

import java.time.LocalDate;
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
                "from Task t left join fetch t.categories where t.id = :tId",
                Task.class,
                Map.of("tId", id)
        );
    }

    @Override
    public Collection<Task> findAll() {
        return crudRepository.query(
                "select distinct t from Task t left join fetch t.categories",
                Task.class
        );
    }

//    @Override
//    public Collection<Task> findByDateRange(LocalDate startDate, LocalDate endDate) {
//        return crudRepository.query(
//                "select distinct t from Task t "
//                        + "left join fetch t.categories "
//                        + "where t.completion between :tStartDate and :tEndDate",
//                Task.class,
//                Map.of("tStartDate", startDate, "tEndDate", endDate)
//        );
//    }

    @Override
    public Collection<Task> findByDateAndStatus(LocalDate startDate, LocalDate endDate, boolean done) {
        return  crudRepository.query(
                "select distinct t from Task t "
                        + "left join fetch t.categories "
                        + "where t.completion between :tStartDate and :tEndDate and t.done = :tDone",
                Task.class,
                Map.of("tStartDate", startDate, "tEndDate", endDate, "tDone", done)
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
                "update from Task set name = :fName, description = :fDescription where id = :fId",
                Map.of("fId",
                        task.getId(),
                        "fName",
                        task.getName(),
                        "fDescription",
                        task.getDescription())
        );
    }

    @Override
    public boolean changeStatus(int id, boolean status) {
        return crudRepository.query(
                "update from Task set done = :fStatus where id = :fId",
                Map.of("fId", id, "fStatus", status)
        );
    }

}
