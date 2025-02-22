package ru.trainee.slepchenko.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trainee.slepchenko.todo.model.Role;
import ru.trainee.slepchenko.todo.repository.RoleRepository;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleRoleService implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Optional<Role> findById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public boolean deleteById(int id) {
        return roleRepository.deleteById(id);
    }

    @Override
    public boolean update(Role role) {
        return roleRepository.update(role);
    }
}
