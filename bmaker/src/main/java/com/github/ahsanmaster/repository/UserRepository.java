package com.github.ahsanmaster.repository;

import com.github.ahsanmaster.model.User;
import com.github.ahsanmaster.util.exeption.UserAlreadyExistsExeption;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ValidationException;
import java.util.List;

@Stateless
public class UserRepository {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public List<User> getAll() {
        return entityManager.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
    }

    public User createUser(User user) {
        User userInDB = entityManager.find(User.class, user.getId());
        if (userInDB != null) {
            throw new UserAlreadyExistsExeption("id: " + user.getId());
        } else {
            entityManager.persist(user);
            return user;
        }
    }


    public User updateUser(User user) {
        if (user == null) {
            throw new ValidationException("User object is null");
        } else {
            entityManager.merge(user);
            return user;
        }
    }

    public boolean deleteUser(int id) {
        return entityManager.createNamedQuery(User.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }
}
