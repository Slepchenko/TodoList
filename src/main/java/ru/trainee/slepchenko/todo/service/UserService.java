package ru.trainee.slepchenko.todo.service;



import ru.trainee.slepchenko.todo.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> save(User todoUser);

    Optional<User> findByLoginAndPassword(String login, String password);

    String findUserNameById(int id);

}
