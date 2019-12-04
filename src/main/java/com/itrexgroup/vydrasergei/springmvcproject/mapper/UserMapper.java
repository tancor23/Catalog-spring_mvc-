package com.itrexgroup.vydrasergei.springmvcproject.mapper;

import com.itrexgroup.vydrasergei.springmvcproject.dto.SimpleBookDto;
import com.itrexgroup.vydrasergei.springmvcproject.dto.UserDto;
import com.itrexgroup.vydrasergei.springmvcproject.entity.BookEntity;
import com.itrexgroup.vydrasergei.springmvcproject.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper implements AbstractMapper<UserDto, UserEntity> {

    @Override
    public UserDto mapToDto(UserEntity entity) {
        List<BookEntity> bookEntityList = entity.getBooks();
        List<SimpleBookDto> simpleBookDtoList = bookEntityList.stream().map(this::mapToSimpleBookDto).collect(Collectors.toList());
        return UserDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .createdAt(entity.getCreatedAt())
                .simpleBookDtoList(simpleBookDtoList)
                .build();
    }

    private SimpleBookDto mapToSimpleBookDto(BookEntity bookEntity) {
        return new SimpleBookDto(bookEntity.getId(), bookEntity.getName(), bookEntity.getAuthor());
    }

    @Override
    public UserEntity mapToEntity(UserDto dto) {
        List<SimpleBookDto> simpleBookDtoList = dto.getSimpleBookDtoList();
        List<BookEntity> bookEntityList = simpleBookDtoList.stream().map(this::mapToBookDto).collect(Collectors.toList());
        return UserEntity.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .createdAt(dto.getCreatedAt())
                .books(bookEntityList)
                .build();
    }

    private BookEntity mapToBookDto(SimpleBookDto simpleBookDto) {
        return new BookEntity(simpleBookDto.getId(), simpleBookDto.getName(), simpleBookDto.getAuthor());
    }
}
