package ru.sberbank.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sberbank.mvc.dto.UserDto;
import ru.sberbank.mvc.service.UserService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;

@Slf4j
@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsersInfo() {
        return "redirect:users";
    }

    @GetMapping("/users")
    public String getUsersInfo(Model model) {
        Collection<UserDto> users = userService.collectAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("error", null);
        model.addAttribute("userEdit", new UserDto());
        return "index";
    }

    @GetMapping("/user/{uuid}")
    public String getUsersInfo(@PathVariable String uuid, Model model) {
        UserDto user = userService.find(uuid);
        if (user == null) {
            model.addAttribute("error", "User not found!");
            user = new UserDto();
        } else {
            model.addAttribute("users", Collections.singleton(user));
        }
        model.addAttribute("userEdit", user);
        return "index";
    }

    @PostMapping("/user")
    public String saveUsersInfo(@Valid @ModelAttribute("user") UserDto user,
                                BindingResult result, ModelMap model) {
        log.info("user at Post Method {}", user);
        if (result.hasErrors()) {
            log.warn("error {}", result);
            return "redirect:";
        }
        userService.persist(user);
        return "redirect:";
    }
}
