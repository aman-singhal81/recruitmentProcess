package com.recruitment.process.repository;

import com.recruitment.process.pojo.Application;
import com.recruitment.process.pojo.Candidate;
import com.recruitment.process.pojo.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@EnableJpaRepositories
@Repository
public interface CandidateRepository extends CrudRepository<Candidate,Long> {

    @Query(value = "select * from candidates where email = :email", nativeQuery = true)
    Candidate findByEmail(@Param("email") String Email);

    @Query(value = "update candidates set  applications = :applications where id= :candidate_id", nativeQuery = true)
    Candidate updateCandidate(@Param("applications") Set<Application> applications, @Param("candidate_id") Long candidate_id);


}
