package com.itrexgroup.vydrasergei.springmvcproject.dto;

import com.itrexgroup.vydrasergei.springmvcproject.entity.BookEntity;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    @Id
    private long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Date createdAt;

    private List<BookEntity> bookEntities;

    public UserDto(@NotNull String firstName, @NotNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
