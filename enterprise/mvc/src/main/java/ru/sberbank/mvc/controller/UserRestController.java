package ru.sberbank.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.mvc.dto.UserDto;
import ru.sberbank.mvc.service.UserService;

@RestController
@Controller
@ResponseBody
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{uuid}", produces = "application/json")
    public UserDto getUser(@PathVariable String uuid) {
        return userService.find(uuid);
    }
}
