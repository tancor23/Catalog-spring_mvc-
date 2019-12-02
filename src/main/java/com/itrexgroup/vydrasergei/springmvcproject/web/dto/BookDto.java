package com.itrexgroup.vydrasergei.springmvcproject.web.dto;

import com.itrexgroup.vydrasergei.springmvcproject.domain.mysql.User;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

public class BookDto {

    @Id
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String author;

    private int page;

    private List<User> users;

}
