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
        List<SimpleBookDto> simpleBookDtoList = new ArrayList<>();
        for (BookEntity bookEntity : bookEntityList) {
            simpleBookDtoList.add(mapToSimpleBookDto(bookEntity));
        }
        return new UserDto(entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getCreatedAt(),
                simpleBookDtoList);
    }

    private SimpleBookDto mapToSimpleBookDto(BookEntity bookEntity) {
        return new SimpleBookDto(bookEntity.getId(), bookEntity.getName(), bookEntity.getAuthor());
    }

    @Override
    public UserEntity mapToEntity(UserDto dto) {
        List<SimpleBookDto> simpleBookDtoList = dto.getSimpleBookDtoList();
        List<BookEntity> bookEntityList = new ArrayList<>();
        for (SimpleBookDto simpleBookDto : simpleBookDtoList) {
            bookEntityList.add(mapToBookDto(simpleBookDto));
        }
        return new UserEntity(dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getCreatedAt(),
                bookEntityList);
    }

    private BookEntity mapToBookDto(SimpleBookDto simpleBookDto) {
        return new BookEntity(simpleBookDto.getId(), simpleBookDto.getName(), simpleBookDto.getAuthor());
    }

    @Override
    public List<UserDto> mapAllToDto(Collection<UserEntity> entityList) {
        return entityList.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<UserEntity> mapAllToEntity(Collection<UserDto> dtoList) {
        return dtoList.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

}
