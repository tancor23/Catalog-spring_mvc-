package com.itrexgroup.vydrasergei.springmvcproject.web.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.itrexgroup.vydrasergei.springmvcproject.domain.mysql.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDto {

    @Id
    private long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Date createdAt;

    private List<Book> books;

    public String getFullName(){
        return firstName + " " + lastName;
    }
}
