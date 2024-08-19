package com.jayavelrajan.expensetrackerapi.service;

import com.jayavelrajan.expensetrackerapi.entity.User;
import com.jayavelrajan.expensetrackerapi.entity.UserModel;

public interface UserService {

    User createUser(UserModel user);

    User readUser(Long id);

    User updateUser(UserModel user, Long id);

    void deleteUser(Long id);
}
