package com.basicauthdemo1.demo;


import com.basicauthdemo1.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({ // workaround for bug. Id was appearing as null.
            @Mapping(target = "id", source = "id")
    })
    UserDTO toUserDTO(User user);
    List<UserDTO> toUserDTO(Collection<User> user);

    User toUserEntity(UserDTO userDTO);
}
