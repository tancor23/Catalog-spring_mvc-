package com.itrexgroup.vydrasergei.springmvcproject.web.controller;

import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;
import com.itrexgroup.vydrasergei.springmvcproject.service.BookService;
import com.itrexgroup.vydrasergei.springmvcproject.service.UserBookService;
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

    @Autowired
    UserBookService userBookService;

    @RequestMapping(value = "/user_info", method = RequestMethod.POST)
    public String goToUserInfoPagePostMethod(ModelMap model, @RequestParam String userId) {
        long id = Long.parseLong(userId);
        User user = userService.findUser(id);
        List<Book> allMappedBookOfUser = userBookService.getAllMappedBookOfUser(id);
        List<String> nameOfBooks = getNameOfBooks(allMappedBookOfUser);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("userBookNames", nameOfBooks);
        model.addAttribute("userBookNameSize", nameOfBooks.size());
        return "user_book_page";
    }

    private List<String> getNameOfBooks(List<Book> books) {
        return books.stream().map(Book::getName).collect(Collectors.toList());
    }

    @RequestMapping(value = "/book_info", method = RequestMethod.POST)
    public String goToBookInfoPagePostMethod(ModelMap model, @RequestParam String bookId) {
        long id = Long.parseLong(bookId);
        Book book = bookService.findBook(id);
        List<User> allMappedUserOfBook = userBookService.getAllMappedUserOfBook(id);
        List<String> userNames = getFullNameOfUser(allMappedUserOfBook);
        model.addAttribute("bookName", book.getName());
        model.addAttribute("bookUserSize", userNames.size());
        model.addAttribute("bookUsers", userNames);
        return "book_user_page";
    }

    private List<String> getFullNameOfUser(List<User> users) {
        return users.stream().map(User::getFullName).collect(Collectors.toList());
    }

    @RequestMapping(value = "/add_mapping", method = RequestMethod.GET)
    public ModelAndView goToAddMappingGetMethod(ModelAndView model) {
        model.setViewName("add_user_book_mapping");
        model.addObject("users", userService.getAllUsers());
        model.addObject("books", bookService.getAllBooks());
        return model;
    }

    @RequestMapping(value = "/add_mapping", method = RequestMethod.POST)
    public ModelAndView goToAddMappingPostMethod(@RequestParam String userSelect, @RequestParam String bookSelect) {
        ModelAndView model = new ModelAndView();
        long userId = Long.parseLong(userSelect);
        long bookId = Long.parseLong(bookSelect);
        if (userBookService.createByIds(userId, bookId)) {
            model.addObject("dbAlert", "Successful");
        } else {
            model.addObject("dbAlert", "This mapping is already in DB");
        }
        return goToAddMappingGetMethod(model);
    }


}

