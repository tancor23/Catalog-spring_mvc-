package com.itrexgroup.vydrasergei.springmvcproject.web.controller;

import com.itrexgroup.vydrasergei.springmvcproject.domain.mysql.User;
import com.itrexgroup.vydrasergei.springmvcproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user", produces="application/json;charset=UTF-8")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToCreateUserPage() {
        return "create_user_page";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUserPostMethod(@RequestParam String userId) {
        long id = Long.parseLong(userId);
        userService.delete(userService.getUserByID(id));
        return "redirect:/main/";
    }

    @RequestMapping(value = "/update_page", method = RequestMethod.POST)
    public ModelAndView updateUserPagePostMethod(@RequestParam String userId, @RequestParam String firstName, @RequestParam String lastName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update_user_page");
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("firstName", firstName);
        modelAndView.addObject("lastName", lastName);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUserPostMethod(@RequestParam String userId, @RequestParam String firstName, @RequestParam String lastName) {
        long id = Long.parseLong(userId);
        User user = userService.getUserByID(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userService.update(user);
        return "redirect:/main/";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String updateBookPostMethod(@RequestParam String firstName, @RequestParam String lastName) {
        User user = new User(firstName, lastName);
        userService.create(user);
        return "redirect:/main/";
    }
}

