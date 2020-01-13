package com.github.ahsanmaster.service;

import com.github.ahsanmaster.model.User;
import com.github.ahsanmaster.repository.UserRepository;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserService implements Serializable {
    @EJB
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User create(User user) {
        return userRepository.createUser(user);
    }

    public boolean delete(int id) {
        return userRepository.deleteUser(id);
    }
}
