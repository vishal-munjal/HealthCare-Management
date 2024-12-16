package com.java.healthcare.service;
import com.java.healthcare.entity.User;
import com.java.healthcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get User by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

   // Get User by Email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Delete User by ID
//    public User deleteUserById(Long id) {
//        userRepository.deleteById(id);
//        return null;
//    }
    public boolean deleteUserById(Long id)
    {
        if(userRepository.existsById(id))
        {
            userRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public Optional<User> updateUser(Long id, User userDetails) {
        // Check if the user exists in the database
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            // Update only the desired fields
            User updatedUser = existingUser.get();
            updatedUser.setName(userDetails.getName());
            updatedUser.setEmail(userDetails.getEmail());
            updatedUser.setRole(userDetails.getRole());
            // Add more fields as necessary

            // Save the updated user
            userRepository.save(updatedUser);

            return Optional.of(updatedUser); // Return the updated user
        } else {
            return Optional.empty(); // Return empty if user not found
        }
    }

    // Check if Email Exists
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    // Check if Phone Exists
    public boolean phoneExists(String phone) {
        return userRepository.existsByPhone(phone);
    }
}

