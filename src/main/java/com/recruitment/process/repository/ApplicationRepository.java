package com.recruitment.process.repository;

import com.recruitment.process.pojo.Application;
import com.recruitment.process.pojo.Offer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application,Long> {

    @Query(value = "select * from application  order by created_date", nativeQuery = true)
    List<Application> findAll();

    @Query(value = "select * from application where email= :email", nativeQuery = true)
    Application findByOfferIdEmail(@Param("email") String email);
}

