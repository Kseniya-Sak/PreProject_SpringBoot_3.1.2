package ru.sakovich.SpringBoot_312.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sakovich.SpringBoot_312.model.User;
import ru.sakovich.SpringBoot_312.repositories.UserRepository;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceJPAImp {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceJPAImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

}
