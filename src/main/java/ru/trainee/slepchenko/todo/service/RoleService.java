package ru.trainee.slepchenko.todo.service;



import ru.trainee.slepchenko.todo.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(String name);

    Optional<Role> findById(int id);

    List<Role> findAll();

    Role save(Role role);

    boolean deleteById(int id);

    boolean update(Role role);

}
