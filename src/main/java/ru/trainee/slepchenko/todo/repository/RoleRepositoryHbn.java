package ru.trainee.slepchenko.todo.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.trainee.slepchenko.todo.model.Role;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class RoleRepositoryHbn implements RoleRepository {

    private final CrudRepository crudRepository;

    @Override
    public Optional<Role> findByName(String name) {
        return crudRepository.optional("from Role where name = :fName", Role.class, Map.of("fName", name));
    }

    @Override
    public Optional<Role> findById(int id) {
        return crudRepository.optional("from Role where id = :fId", Role.class, Map.of("fId", id));
    }

    @Override
    public List<Role> findAll() {
        return crudRepository.query("from Role", Role.class);
    }

    @Override
    public Role save(Role role) {
        crudRepository.run(session -> session.persist(role));
        return role;
    }

    @Override
    public boolean deleteById(int id) {
        return crudRepository.query("delete from Role where id = :fId", Map.of("fId", id));
    }

    @Override
    public boolean update(Role role) {
        return crudRepository.query("update from Role set name = :fName where id = :fId",
                Map.of("fName", role.getName(), "fId", role.getId()));
    }

}