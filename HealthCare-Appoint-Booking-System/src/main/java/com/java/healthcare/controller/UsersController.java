package com.java.healthcare.controller;

import com.java.healthcare.entity.User;
import com.java.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService usersService;

    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(201).body(usersService.saveUser(user));
    }

    @GetMapping("/getUserById")
    public ResponseEntity<?> getUserById(@RequestParam Long id) {
        Optional<User> user = usersService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not present with ID: " + id);
        }
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestParam Long id, @RequestBody User user)    {
        usersService.updateUser(id,user);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        usersService.deleteUserById(id);
//        return ResponseEntity.noContent().build();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        boolean isDeleted=usersService.deleteUserById(id);
        if(isDeleted) {
            return ResponseEntity.ok("User deleted Successfully..!! "+id);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found.! "+id);
        }
    }

}
