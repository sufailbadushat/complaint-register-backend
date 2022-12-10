package com.nest.complaint_register_backend.controller;

import com.nest.complaint_register_backend.dao.UserDao;
import com.nest.complaint_register_backend.model.ComplaintModel;
import com.nest.complaint_register_backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController

public class UserController {

    @Autowired
    private UserDao userDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userReg", produces = "application/json",consumes = "application/json")
    public HashMap<String, String> UserRegister(@RequestBody UserModel userModel){

        userDao.save(userModel);
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("status","success");
        return hashMap;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/getById", produces = "application/json",consumes = "application/json")
    public List<UserModel> getUser(@RequestBody UserModel userModel){
        String id=String.valueOf(userModel.getId());
        System.out.println(id);
        return (List<UserModel>) userDao.Getuser(userModel.getId());

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userLogin", produces = "application/json",consumes = "application/json")
    public Map<String,String> userLogin(@RequestBody UserModel userModel){
        String username=String.valueOf(userModel.getUsername());
        String password=String.valueOf(userModel.getPassword());
        System.out.println(username+ " \n" + password);
        List<UserModel> result=(List<UserModel>) userDao.UserLogin(userModel.getUsername(),userModel.getPassword());

        HashMap<String,String> hashMap=new HashMap<>();
        if(result.size()!=0){
            int id=result.get(0).getId();
            System.out.println(id);
            hashMap.put("id",String.valueOf(id));
            hashMap.put("status","success");
        }
        else {
            hashMap.put("status","failed");
        }

        return hashMap;
    }



}
