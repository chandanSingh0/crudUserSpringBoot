package com.cm.userApp.userRestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Random;

@Service
public class UserService {


    @Autowired
    private UserRepo usRep;

    public UserEntity createUser(UserEntity userE) {
        Random ran = new Random();
        int id = ran.nextInt();
        String id1 = "coding-"+id+"-Moments";
        userE.setUid(id1);
        return usRep.save(userE);
    }

    public UserEntity searchById(Integer id) {
       UserEntity user = usRep.findById(id).orElseThrow(()->new RuntimeException("not found"));
       return user;
    }

    public List<UserEntity> getUsers() {
        return usRep.findAll();
    }

    public UserEntity updUserById(Integer id, UserEntity userEn) {
        UserEntity user = usRep.findById(id).orElseThrow(()->new RuntimeException("not found"));
        user.setName(userEn.getName());
        user.setPhone(userEn.getPhone());
        usRep.save(userEn);
        return user;
    }

    public void delUserByuserId(Integer id) {
        UserEntity user = usRep.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }
}
