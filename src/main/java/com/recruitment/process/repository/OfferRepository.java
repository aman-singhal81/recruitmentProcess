package com.recruitment.process.repository;

import com.recruitment.process.pojo.Offer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@EnableJpaRepositories
@Repository
public interface OfferRepository extends CrudRepository<Offer,Long> {
    @Query(value = "select * from offer where job_title = :jobTitle", nativeQuery = true)
    Offer findByjobTitle(@Param("jobTitle") String jobTitle);

    @Query(value = "select * from offer", nativeQuery = true)
    List<Offer> findAll();
    @Modifying
    @Query(value = "update offer set number_of_application = :numberOfApplication where job_title = :jobTitle", nativeQuery = true)
    void setNumberOfApplication(@Param("numberOfApplication") Long numberOfApplication, @Param("jobTitle") String jobTitle);

}

