package com.nest.complaint_register_backend.controller;

import com.nest.complaint_register_backend.dao.ComplaintDao;
import com.nest.complaint_register_backend.model.ComplaintModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class ComplaintController {

    @Autowired
    private ComplaintDao complaintDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addComplaint", produces = "application/json",consumes = "application/json")
    public Map<String,String> addComplaint(@RequestBody ComplaintModel complaintModel){

        complaintDao.save(complaintModel);

        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("status", "success");
        return hashMap;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/getComplaintById", produces = "application/json",consumes = "application/json")
    public List<ComplaintModel> getComplaintById(@RequestBody ComplaintModel complaintModel){

        System.out.println(complaintModel.getUserId());
       return (List<ComplaintModel>) complaintDao.getComplaintById(complaintModel.getUserId());
    }
}
