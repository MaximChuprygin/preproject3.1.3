package ru.kata.spring.boot_security.demo.dao;



import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public User findUserById(Long id);

    public void saveUser(User user);

    public void update(Long id, User updateduser);


    public void delete(Long id);
}
