package com.itrexgroup.vydrasergei.springmvcproject.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Builder
@Table(name = "user_book", schema = "catalog_mysql")
public class UserBookEntity {

    @EmbeddedId
    @Column(unique = true)
    UserBookPKEntity userBookPKEntity;

}

