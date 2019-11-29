package com.itrexgroup.vydrasergei.springmvcproject.domain.util.mysql;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "books", schema = "catalog_mysql")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id = -1;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "page")
    private int page;

/*    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_book",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })*/
    @ManyToMany(mappedBy="books", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author, int page) {
        this.name = name;
        this.author = author;
        this.page = page;
    }
}

