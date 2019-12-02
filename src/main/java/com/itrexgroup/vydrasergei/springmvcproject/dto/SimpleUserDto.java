package com.itrexgroup.vydrasergei.springmvcproject.dto;

import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SimpleUserDto {

    @Id
    private long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    public SimpleUserDto(@NotNull String firstName, @NotNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
