package com.nest.complaint_register_backend.dao;

import com.nest.complaint_register_backend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel, Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `gender`, `name`, `password`, `phone`, `pincode`, `username` FROM `user` WHERE `id`=:id",nativeQuery = true)
    List<UserModel> Getuser(@Param("id") int id);

}
