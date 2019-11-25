package com.itrexgroup.vydrasergei.springmvcproject.service;

import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.Book;
import com.itrexgroup.vydrasergei.springmvcproject.domain.entity.User;

import java.util.List;

public interface UserBookService {

    List<Book> getAllMappedBookOfUser(Long userId);

    List<User> getAllMappedUserOfBook(Long bookId);

    boolean createByIds(Long userId, Long bookId);
}
