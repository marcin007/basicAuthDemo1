package com.basicauthdemo1.demo.controller;

import com.basicauthdemo1.demo.ApiInfo;
import com.basicauthdemo1.demo.entity.User;
import com.basicauthdemo1.demo.PatchUserDTO;
import com.basicauthdemo1.demo.UserDTO;
import com.basicauthdemo1.demo.UserMapper;
import com.basicauthdemo1.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

//    @IsAdmin
    @GetMapping("/users")
    public List<UserDTO> getUsers( ){
        return userMapper.toUserDTO(userService.getUsers());
    }

    @GetMapping("/users/{user_id}")
    public UserDTO getUserById(@PathVariable("user_id") Long id){
        return userMapper.toUserDTO(userService.findUserById(id));
    }

    @PostMapping("/users")
    public UserDTO postUser(@RequestBody UserDTO user){
        return userMapper.toUserDTO(userService.postUser(userMapper.toUserEntity(user)));
    }

    @DeleteMapping("/users/{id}")
    public ApiInfo deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return new ApiInfo("Deleted user", HttpStatus.OK.value());
    }

    @PatchMapping("/users/{id}")
    public User updateUserById(@PathVariable Long id, @Valid @RequestBody PatchUserDTO userDTO){
        return userService.updateUserById(id, userDTO);
    }


}
