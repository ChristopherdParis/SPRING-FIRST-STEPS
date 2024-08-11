package com.christopher.spring.springbootweb.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christopher.spring.springbootweb.models.User;
import com.christopher.spring.springbootweb.models.dto.UserDto;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details()
    {
        User user = new User("Christopher","tumi");
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("hola, s[trom nit]");
        
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){
        User user1 = new User("Christopher","tumi");
        User user2 = new User("Christopher","tumi");
        User user3 = new User("Christopher","tumi");
        // otra opcion
        List<User> userotro = Arrays.asList(user1,user2,user3);
        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }

    @GetMapping("/details3")
    public Map<String, Object> details2()
    {
        User user = new User("christopher","tumi roque");
        Map<String, Object> body = new HashMap<>();

        body.put("titulo", "gola mundo spring boot");
        body.put("user", user);
        
        return body;
    }
}
