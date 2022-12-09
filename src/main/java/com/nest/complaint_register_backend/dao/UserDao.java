package com.nest.complaint_register_backend.dao;

import com.nest.complaint_register_backend.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserModel, Integer> {
}
