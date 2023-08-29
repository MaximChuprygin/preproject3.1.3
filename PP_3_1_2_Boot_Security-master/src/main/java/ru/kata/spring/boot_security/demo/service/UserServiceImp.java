package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.models.User;


import java.util.List;

;


@Service
@Transactional
public class UserServiceImp implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    //UserDaoImp userDaoImp = new UserDaoImp();

    public List<User> getAllUsers(){
       return userDao.getAllUsers();
    }
    public User findUserById(Long id){
        return userDao.findUserById(id);
    }
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    public void update(Long id, User updateduser) {
        userDao.update(id,updateduser);
    }
    public void delete(Long id) {
        userDao.delete(id);
    }
}
