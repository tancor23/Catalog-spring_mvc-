package com.itrexgroup.vydrasergei.springmvcproject.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "user_book", schema = "catalog_mysql")
public class UserBook {


    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_id")
    private Long bookId;
}

