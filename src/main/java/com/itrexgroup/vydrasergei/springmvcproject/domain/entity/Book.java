package com.itrexgroup.vydrasergei.springmvcproject.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book" , schema = "catalog_mysql")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false, unique=true)
    private long id = -1;

    @Column(name = "name", nullable=false)
    private String name;

    @Column(name = "author", nullable=false)
    private String author;

    @Column(name = "page")
    private int page;

    public Book(){}

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author, int page) {
        this.name = name;
        this.author = author;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                page == book.page &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, page);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", page=" + page +
                '}';
    }
}

