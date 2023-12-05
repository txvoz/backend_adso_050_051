package edu.co.sena.apiclient.controllers;

import edu.co.sena.apiclient.contracts.PersonDto;
import edu.co.sena.apiclient.contracts.UserDto;
import edu.co.sena.apiclient.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping()
    public String create(@RequestBody UserDto request) {
        this.service.create(request);
        return "ok";
    }

    @GetMapping
    public List<UserDto> getAll(){
        return this.service.getAllUsers();
    }

}
