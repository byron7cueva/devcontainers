package com.webapi.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapi.user.dto.UserDto;
import com.webapi.user.services.IUserService;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("users")
@Lazy
public class UserController {
    @Autowired
    @Lazy
    private IUserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> userList = userService.getAll();
        return new ResponseEntity<List<UserDto>>(userList, HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDto> findById(@NotNull @PathVariable Long userId) {
        UserDto userDto = userService.findById(userId);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
        UserDto userDto = userService.create(user);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
    }

    @PatchMapping("{userId}")
    public ResponseEntity<Void> update(@NotNull @PathVariable Long userId, @RequestBody UserDto user) {
        userService.update(userId, user);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> delete(@NotNull @PathVariable Long userId) {
        userService.inactive(userId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
