package ru.trainee.slepchenko.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trainee.slepchenko.todo.model.User;
import ru.trainee.slepchenko.todo.repository.UserRepository;


import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public String findUserNameById(int id) {
        return userRepository.findUserNameById(id);
    }
}
