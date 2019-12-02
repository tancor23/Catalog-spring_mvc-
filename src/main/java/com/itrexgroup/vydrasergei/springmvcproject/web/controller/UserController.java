package com.itrexgroup.vydrasergei.springmvcproject.web.controller;

import com.itrexgroup.vydrasergei.springmvcproject.entity.UserEntity;
import com.itrexgroup.vydrasergei.springmvcproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToCreateUserPage() {
        return "create_user_page";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUserPostMethod(@RequestParam String userId) {
        long id = Long.parseLong(userId);
        userService.delete(userService.getUserEntityByID(id));
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
        UserEntity userEntity = userService.getUserEntityByID(id);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userService.update(userEntity);
        return "redirect:/main/";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String updateBookPostMethod(@RequestParam String firstName, @RequestParam String lastName) {
        UserEntity userEntity = new UserEntity(firstName, lastName);
        userService.create(userEntity);
        return "redirect:/main/";
    }
}

