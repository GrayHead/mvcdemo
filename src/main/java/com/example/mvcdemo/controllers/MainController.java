package com.example.mvcdemo.controllers;

import com.example.mvcdemo.dao.UserDAO;
import com.example.mvcdemo.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
@AllArgsConstructor
public class MainController {

    private UserDAO userDAO;


    @GetMapping("/")
    public String home() {
        return "index.html";
    }


    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("x", "hello world");
        return "hello.html";
    }


    @PostMapping("/save")
    public String save(@RequestParam Map<String, String> map) {
        System.out.println(map);
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }


        return "index.html";
    }

    @GetMapping("/save")
    public String saveGet(@RequestParam("username") String name,
                          Model model) {
        System.out.println(name);
        userDAO.save(new User(name));
        model.addAttribute("users", userDAO.findAll());

        return "users.html";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable int id, Model model) {
        User one = userDAO.getOne(id);

        model.addAttribute("user", one);


        return "user.html";
    }
}
