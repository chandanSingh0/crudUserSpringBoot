package com.cm.userApp.userRestApi;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService usSer;

    @PostMapping("/create")
     public ResponseEntity<UserEntity>createUser(@RequestBody UserEntity userE){
          return new ResponseEntity<>(usSer.createUser(userE), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id){
        return new ResponseEntity<>(usSer.searchById(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getUsers(){
        return new ResponseEntity<>(usSer.getUsers(),HttpStatus.ACCEPTED);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Integer id,@RequestBody UserEntity userEn){
        return new ResponseEntity<>(usSer.updUserById(id,userEn),HttpStatus.CREATED);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> delBYuserId(@PathVariable Integer id){
        usSer.delUserByuserId(id);

        return new ResponseEntity<>("User is deleted "+id,HttpStatus.OK);

    }




}
