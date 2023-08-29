package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


import java.util.List;


@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    //@Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }
    //@Transactional
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    //@Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    //@Transactional
    public void update(Long id, User updateduser) {
        entityManager.merge(updateduser);
        entityManager.flush();

    }

    //@Transactional
    public void delete(Long id) throws NullPointerException {
        User user = findUserById(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        entityManager.flush();
    }

}
