package com.nest.complaint_register_backend.dao;

import com.nest.complaint_register_backend.model.ComplaintModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ComplaintDao extends CrudRepository<ComplaintModel , Integer> {

    @Query(value = "SELECT `id`, `complaint`, `user_id` FROM `complaint` WHERE `user_id`=:userId", nativeQuery = true)
    List<ComplaintModel> getComplaintById(@Param("userId") Integer userId);

    @Query(value = "SELECT u.`address`, u.`email`, u.`name`, u.`phone`, u.`username`, c.complaint FROM `user` u JOIN complaint c ON u.id=c.user_id",nativeQuery = true)
    List<Map<String,String>> viewAll();
}
