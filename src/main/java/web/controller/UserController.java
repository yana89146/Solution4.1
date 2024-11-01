package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.Optional;


@Controller
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping(value = "/result")
    public String showList(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "result";
    }

    @GetMapping(value = "/")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping(value = "/result")
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/result";
    }

    @GetMapping(value = "/delete")
    public String delete(Model model, @RequestParam(required = false, defaultValue = "0") Long id) {
        userService.deleteById(id);
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/result";
    }

    @GetMapping(value = "/update")
    public String chooseUserForUpdate(Model model, @RequestParam Long id) {
        Optional<User> user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("newUser", new User());
        return "update";
    }


    @PostMapping(value = "/updateAndSave")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateById(user,user.getId());
        return "redirect:/result";
    }

    @GetMapping(value = "/updateAndSave")
    public String showUpdatedUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/result";
    }


}
