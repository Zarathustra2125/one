package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.List;
import java.util.Set;

@RestController
public class AdminController {

    private UserService userService;

    @Autowired
    public void AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public User userInfo() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping("/allUsers")
    public List<User> allUsers() {
        return userService.allUsers();
    }

    @GetMapping("/allRoles")
    public Set<Role> allRoles() {
        return userService.getAllRoles();
    }

    @GetMapping("/newUser")
    public User createUser() {
        return new User();
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userService.add(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/editUser")
    public ResponseEntity<?> editUser(@RequestBody User user) {
        userService.edit(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        userService.remove(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable(name = "id") Long id) {
        return userService.getById(id);
    }

}
