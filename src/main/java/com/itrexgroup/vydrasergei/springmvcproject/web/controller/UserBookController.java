package com.itrexgroup.vydrasergei.springmvcproject.web.controller;

import com.itrexgroup.vydrasergei.springmvcproject.entity.BookEntity;
import com.itrexgroup.vydrasergei.springmvcproject.entity.UserEntity;
import com.itrexgroup.vydrasergei.springmvcproject.service.BookService;
import com.itrexgroup.vydrasergei.springmvcproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/user_book", produces = "application/json;charset=UTF-8")
public class UserBookController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/user_info", method = RequestMethod.POST)
    public String goToUserInfoPagePostMethod(ModelMap model, @RequestParam String userId) {

        return "user_book_page";
    }

    private List<String> getNameOfBooks(List<BookEntity> bookEntities) {
        return bookEntities.stream().map(BookEntity::getName).collect(Collectors.toList());
    }

    @RequestMapping(value = "/book_info", method = RequestMethod.POST)
    public String goToBookInfoPagePostMethod(ModelMap model, @RequestParam String bookId) {

        return "book_user_page";
    }

    private List<String> getFullNameOfUser(List<UserEntity> userEntities) {
        return userEntities.stream().map(UserEntity::getFullName).collect(Collectors.toList());
    }

    @RequestMapping(value = "/add_mapping", method = RequestMethod.GET)
    public ModelAndView goToAddMappingGetMethod(ModelAndView model) {

        return model;
    }

    @RequestMapping(value = "/add_mapping", method = RequestMethod.POST)
    public ModelAndView goToAddMappingPostMethod(@RequestParam String userSelect, @RequestParam String bookSelect) {
        ModelAndView model = new ModelAndView();
        long userId = Long.parseLong(userSelect);
        long bookId = Long.parseLong(bookSelect);
        return goToAddMappingGetMethod(model);
    }


}

