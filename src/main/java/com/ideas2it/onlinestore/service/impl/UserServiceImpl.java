package com.ideas2it.onlinestore.service.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.onlinestore.model.User;
import com.ideas2it.onlinestore.repository.UserRepository;
import com.ideas2it.onlinestore.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User viewUserDetails(int id) {
        User user = userRepository.getById(id);

        if (null == user || user.isStatus()) {
            System.out.println("Exception");
        }
        return user;
    }

    @Override
    public boolean updateUserDetails(User user) {
        boolean isUpdated = false;
        user = userRepository.save(user);

        if (null != user) {
            return isUpdated;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteUser(int id) {
        User user = viewUserDetails(id);

        if (null != user) {
            user.setStatus(true);
            return userRepository.save(user).equals(user);
        }
        return false;
    }

    @Override
    public List<User> viewAllUserDetails() {
        List<User> users = userRepository.findAll();

        if (null != users || users.isEmpty()) {
            List<User> filterUsers = new CopyOnWriteArrayList<>();
            filterUsers.addAll(users);

            for (User user: filterUsers) {
                if (user.isStatus()) {
                    filterUsers.remove(user);
                }
            }
            if (filterUsers.isEmpty()) {
                System.out.println("Exception");
            }
            return filterUsers;
        } else {
            System.out.println("Exception");
        }
        return users;
    }

    @Override
    public boolean isUserExist(int id) {
        return userRepository.existsById(id);
    }
}
