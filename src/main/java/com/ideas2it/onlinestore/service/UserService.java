package com.ideas2it.onlinestore.service;

import com.ideas2it.onlinestore.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User viewUserDetails(int id);
    boolean updateUserDetails(User user);
    boolean deleteUser(int id);
    List<User> viewAllUserDetails();
    boolean isUserExist(int id);
}
