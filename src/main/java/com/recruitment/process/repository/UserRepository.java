package com.recruitment.process.repository;

import com.recruitment.process.pojo.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Query(value = "select * from users where user_name = :name", nativeQuery = true)
    User findByName(@Param("name") String userName);

}
