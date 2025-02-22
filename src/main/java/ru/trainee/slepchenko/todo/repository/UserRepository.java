package ru.trainee.slepchenko.todo.repository;

import ru.trainee.slepchenko.todo.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> save(User user);

    Optional<User> findByLoginAndPassword(String login, String password);

    String findUserNameById(int id);

}
