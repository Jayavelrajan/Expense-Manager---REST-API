package com.jayavelrajan.expensetrackerapi.service;

import com.jayavelrajan.expensetrackerapi.entity.User;
import com.jayavelrajan.expensetrackerapi.entity.UserModel;
import com.jayavelrajan.expensetrackerapi.exceptions.ItemAlreadyExistsException;
import com.jayavelrajan.expensetrackerapi.exceptions.ResourceNotFoundException;
import com.jayavelrajan.expensetrackerapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(UserModel user) {

        if(userRepository.existsByEmail(user.getEmail())){
            throw new ItemAlreadyExistsException("User is already registered with email : " + user.getEmail());
        }




        User newUser = new User();
        BeanUtils.copyProperties(user,newUser);
        newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    @Override
    public User readUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not found for id: " + id));
    }

    @Override
    public User updateUser(UserModel user, Long id) {
        User existingUser = readUser(id);
        existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
        existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null ? bcryptEncoder.encode(user.getPassword()) : existingUser.getPassword());
        existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = readUser(id);
        userRepository.delete(existingUser);
    }
}
