package com.itrexgroup.vydrasergei.springmvcproject.dto;

import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDto {

    @Id
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String author;

    private int page;

    public BookDto(@NotNull String name, @NotNull String author) {
        this.name = name;
        this.author = author;
    }

    public BookDto(@NotNull String name, @NotNull String author, int page) {
        this.name = name;
        this.author = author;
        this.page = page;
    }

    private List<Long> userDtos;

}
