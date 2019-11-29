package com.itrexgroup.vydrasergei.springmvcproject.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "user_book", schema = "catalog_mysql",  uniqueConstraints=
@UniqueConstraint(columnNames={"user_id", "book_id"}))
public class UserBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id = -1;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "book_id", nullable = false)
    private Long bookId;
}

