package com.nest.complaint_register_backend.dao;

import com.nest.complaint_register_backend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel, Integer> {

    @Query(value = "SELECT `id`, `address`, `email`,`name`, `password`, `phone`, `username` FROM `user` WHERE `id`=:id",nativeQuery = true)
    List<UserModel> Getuser(@Param("id") int id);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `user` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<UserModel> UserLogin(@Param("username") String username, @Param("password") String password);

}
