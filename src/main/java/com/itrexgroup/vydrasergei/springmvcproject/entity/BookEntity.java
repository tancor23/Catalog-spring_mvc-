package com.itrexgroup.vydrasergei.springmvcproject.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "books", schema = "catalog_mysql")
public class BookEntity {

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
/*    @ManyToMany(mappedBy="books", fetch = FetchType.LAZY)
    private List<User> users;*/

    public BookEntity(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public BookEntity(String name, String author, int page) {
        this.name = name;
        this.author = author;
        this.page = page;
    }
}

