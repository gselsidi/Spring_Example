package com.example.demo.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.shared.dto.UserDto;
import com.example.demo.ui.model.request.UserDetailsRequest;
import com.example.demo.ui.model.response.UserDetailsResponse;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;
	
    @GetMapping
    public String getUser() {

        return "Get User was called";
    }

    @PostMapping
    public UserDetailsResponse createUser(@RequestBody UserDetailsRequest userDetails) {

    	UserDetailsResponse response = new UserDetailsResponse();
    	UserDto userDto = new UserDto();
    	
    	// Copy Request Body to user Data Transfer Object
    	BeanUtils.copyProperties(userDetails, userDto);
    	
    	// Create User
    	UserDto createdUser = userService.createUser(userDto);
    	
    	// Copy createdUser to response
    	BeanUtils.copyProperties(createdUser, response);

    	return response;
    }

    @PutMapping
    public String updateUser() {

        return "Update User was called";
    }

    @DeleteMapping
    public String deleteUser() {

        return "Delete User was called";
    }
}
