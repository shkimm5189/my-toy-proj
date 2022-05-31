package com.resell.toyprj.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/new")
    public String createForm(@ModelAttribute("userForm")UserForm form) {
        return "users/createUsersForm";
    }

    @PostMapping("/users/new")
    public String create(@Validated @ModelAttribute("userForm")UserForm form,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "users/createUsersForm";
        }

        User user = new User();
        user.setAccount(form.getAccount());
        user.setPassword(form.getPassword());
        user.setAstatus("일반회원");
        user.setEmail(form.getEmail());
        user.setPhone(form.getPhone());
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy(form.getAccount());

        userService.join(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String list(Model model) {
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "users/userList";
    }

    @GetMapping("/users/{userId}")
    public String user(@PathVariable("userId") Long userId, Model model) {
        User user = userService.findUser(userId);
        model.addAttribute("user", user);

        return "users/user";
    }

    @GetMapping("/users/{userId}/edit")
    public String editForm(@PathVariable("userId")Long userId, Model model) {
        User user = userService.findUser(userId);
        model.addAttribute("user", user);

        return "users/editForm";
    }

    @PostMapping("/users/{userId}/edit")
    public String edit(@PathVariable("userId")Long userId,
                       @Validated @ModelAttribute("user")UpdateUserForm form,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "users/editForm";
        }

        User user = new User();
        user.setAccount(form.getAccount());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        user.setAstatus("일반회원");
        user.setPhone(form.getPhone());
        user.setUpdatedAt(LocalDateTime.now());
        user.setUpdatedBy(form.getAccount());

        userService.update(userId, user);
        return "redirect:/users/{userId}";
    }

}
