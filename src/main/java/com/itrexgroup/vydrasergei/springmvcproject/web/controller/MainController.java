package com.itrexgroup.vydrasergei.springmvcproject.web.controller;

import com.itrexgroup.vydrasergei.springmvcproject.service.BookService;
import com.itrexgroup.vydrasergei.springmvcproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {

    //private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String prepareMainViewGetMethod(ModelMap model) {
        //modelMapper.map()

        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("books", bookService.getAllBooks());
        return "main_page";
    }
}

