package com.itrexgroup.vydrasergei.springmvcproject.dao.mysql;

import java.util.List;

public interface UserBookDAO {

    boolean createByIds(Long userId, Long bookId);

    List<Long> getAllMappedBookIds(Long userId);

    List<Long> getAllMappedUserIds(Long bookId);

}