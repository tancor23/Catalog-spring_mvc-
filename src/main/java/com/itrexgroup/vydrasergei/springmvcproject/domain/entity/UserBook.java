package com.itrexgroup.vydrasergei.springmvcproject.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "user_book", schema = "catalog_mysql")
public class UserBook {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_id")
    private Long bookId;

    public UserBook(){}

    public UserBook(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBook userBook = (UserBook) o;
        return Objects.equals(userId, userBook.userId) &&
                Objects.equals(bookId, userBook.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, bookId);
    }

    @Override
    public String toString() {
        return "UserBook{" +
                "userId=" + userId +
                ", bookId=" + bookId +
                '}';
    }
}

