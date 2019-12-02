package com.itrexgroup.vydrasergei.springmvcproject.web.controller;

import com.itrexgroup.vydrasergei.springmvcproject.dto.BookDto;
import com.itrexgroup.vydrasergei.springmvcproject.entity.BookEntity;
import com.itrexgroup.vydrasergei.springmvcproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToCreateBookPage() {
        return "create_book_page";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteBookPostMethod(@RequestParam String bookId) {
        long id = Long.parseLong(bookId);
        bookService.delete(bookService.getBookByID(id));
        return "redirect:/main/";
    }

    @RequestMapping(value = "/update_page", method = RequestMethod.POST)
    public ModelAndView updateBookPagePostMethod(@RequestParam String bookId, @RequestParam String bookName, @RequestParam String authorName, @RequestParam String countOfPage) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update_book_page");
        modelAndView.addObject("bookId", bookId);
        modelAndView.addObject("bookName", bookName);
        modelAndView.addObject("authorName", authorName);
        modelAndView.addObject("countOfPage", countOfPage);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBookPostMethod(@RequestParam String bookId, @RequestParam String bookName, @RequestParam String authorName, @RequestParam String countOfPage) {
        long id = Long.parseLong(bookId);
        BookDto bookDto = bookService.getBookByID(id);
        bookDto.setName(bookName);
        bookDto.setAuthor(authorName);
        int page;
        try {
            page = Integer.parseInt(countOfPage);
        } catch (NumberFormatException e) {
            page = 1;
        }
        bookDto.setPage(page);
        bookService.update(bookDto);
        return "redirect:/main/";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String updateBookPostMethod(@RequestParam String bookName, @RequestParam String authorName, @RequestParam String countOfPage) {
        int page;
        try {
            page = Integer.parseInt(countOfPage);
        }catch (NumberFormatException e){
            page = 1;
        }
        BookDto bookDto = new BookDto(bookName, authorName, page);
        bookService.create(bookDto);
        return "redirect:/main/";
    }
}

