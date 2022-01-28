package com.example.ipassignment.controller;

import com.example.ipassignment.exceptions.IpApiException;
import com.example.ipassignment.exceptions.IpNotInDesiredCountryException;
import com.example.ipassignment.model.User;
import com.example.ipassignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController()
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Object> register(@Valid @RequestBody User user) {
        ResponseEntity<Object> response;
        try {
            response = new ResponseEntity<>(userService.register(user), HttpStatus.OK);
        } catch (IpApiException e) {
            response = new ResponseEntity<>("Cannot determine geographic location of Ip address", HttpStatus.FAILED_DEPENDENCY);
        } catch (IpNotInDesiredCountryException e) {
            response = new ResponseEntity<>("User is NOT from the desired country !!", HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
