package com.myapi.javasql.controller;

import com.myapi.javasql.model.User;
import com.myapi.javasql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo") // this mean URL'start with /demo
public class MainController {
    @Autowired //this mean to get the bean called userRepisotery
    //Which is auto-generated by Spring, we will use it handle th data
    private UserRepository userRepository;

    @PostMapping(path = "/add") //Map Only POST Request
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
