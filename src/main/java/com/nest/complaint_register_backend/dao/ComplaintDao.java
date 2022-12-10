package com.nest.complaint_register_backend.dao;

import com.nest.complaint_register_backend.model.ComplaintModel;
import org.springframework.data.repository.CrudRepository;

public interface ComplaintDao extends CrudRepository<ComplaintModel , Integer> {

}
