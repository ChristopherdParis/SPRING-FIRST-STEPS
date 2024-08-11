package com.christopher.spring.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christopher.spring.springbootweb.models.User;
import com.christopher.spring.springbootweb.models.dto.ParamDto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.listOfValues}")
    private String[] listOfValue;

    @Value("${config.code}")
    private Integer code;

    @Autowired
    private Environment enviroment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}-{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Integer id ) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        return user;
    }
    
    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String messagse) {
        Integer code2 = enviroment.getProperty("config.code",Integer.class);
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", messagse);
        json.put("message2", enviroment.getProperty("config.message"));
        json.put("message2", code2);
        json.put("list", listOfValue);
        return json;
    }
    
    
    
}
