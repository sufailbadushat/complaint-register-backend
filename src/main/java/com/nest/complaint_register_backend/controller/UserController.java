package com.nest.complaint_register_backend.controller;

import com.nest.complaint_register_backend.dao.UserDao;
import com.nest.complaint_register_backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController

public class UserController {

    @Autowired
    UserDao userDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userReg", produces = "application/json",consumes = "application/json")
    public HashMap<String, String> UserRegister(@RequestBody UserModel userModel){

        userDao.save(userModel);
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("status","success");
        return hashMap;
    }
}
