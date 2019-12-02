package com.itrexgroup.vydrasergei.springmvcproject.mapper;

import com.itrexgroup.vydrasergei.springmvcproject.dto.BookDto;
import com.itrexgroup.vydrasergei.springmvcproject.dto.SimpleUserDto;
import com.itrexgroup.vydrasergei.springmvcproject.entity.BookEntity;
import com.itrexgroup.vydrasergei.springmvcproject.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BookMapper implements AbstractMapper<BookDto, BookEntity> {

    @Override
    public BookDto mapToDto(BookEntity entity) {
        List<UserEntity> userEntityList = entity.getUsers();
        List<SimpleUserDto> simpleUserDtoList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            simpleUserDtoList.add(mapToSimpleUserDto(userEntity));
        }
        return new BookDto(entity.getId(),
                entity.getName(),
                entity.getAuthor(),
                entity.getPage(),
                simpleUserDtoList);
    }

    private SimpleUserDto mapToSimpleUserDto(UserEntity userEntity) {
        return new SimpleUserDto(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName());
    }

    @Override
    public BookEntity mapToEntity(BookDto dto) {
        List<SimpleUserDto> simpleUserDtoList = dto.getSimpleUserDtoList();
        List<UserEntity> userEntityList = new ArrayList<>();
        for (SimpleUserDto simpleUserDto : simpleUserDtoList) {
            userEntityList.add(mapToUserDto(simpleUserDto));
        }
        return new BookEntity(dto.getId(),
                dto.getName(),
                dto.getAuthor(),
                dto.getPage(),
                userEntityList);
    }

    private UserEntity mapToUserDto(SimpleUserDto simpleUserDto) {
        return new UserEntity(simpleUserDto.getId(), simpleUserDto.getFirstName(), simpleUserDto.getLastName());
    }

    @Override
    public List<BookDto> mapAllToDto(Collection<BookEntity> entityList) {
        return entityList.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<BookEntity> mapAllToEntity(Collection<BookDto> dtoList) {
        return dtoList.stream().map(this::mapToEntity).collect(Collectors.toList());
    }

}
