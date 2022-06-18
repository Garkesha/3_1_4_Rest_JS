package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void addTestUsers(){
        Set<Role> userRole = new HashSet<>();
        userRole.add(roleService.getRoleByName("ROLE_USER"));
        Set<Role> adminRole = new HashSet<>();
        adminRole.add(roleService.getRoleByName("ROLE_ADMIN"));

        userService.saveUser(new User("admin",
                "1234",
                "Ivan",
                "Ivanov",
                (byte) 33,
                adminRole));
        userService.saveUser(new User("user",
                "1111",
                "Sergey",
                "Sergeev",
                (byte) 20,
                userRole));
    }

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

    @GetMapping("/info")
    public ResponseEntity<?> getUser() {
        UserDetails userDetails
                = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserByUsername(userDetails.getUsername());
        return ResponseEntity.ok().body(user);
    }

}
