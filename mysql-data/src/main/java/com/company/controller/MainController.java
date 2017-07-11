package com.company.controller;

import com.company.DO.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by huanbenwang on 2017/7/6.
 */
@Controller
@RequestMapping(path = "/user")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);

        return "Saved";
    }

    @GetMapping(path="all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "names")
    @ResponseBody
    public List<User> getUsersByName(@RequestParam(value = "name") String firstName){
        return userRepository.findByNameStartsWithIgnoreCase(firstName);
    }

    @GetMapping(path = "ids/{id}")
    @ResponseBody
    public List<User> getUsersById(@PathVariable(name = "id") String id){
        return userRepository.findByIdStartsWithIgnoreCase(id);
    }

}
