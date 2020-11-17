package com.recruitment.process.service;

import com.recruitment.process.constants.Constants;
import com.recruitment.process.pojo.User;
import com.recruitment.process.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        log.info("Saving user");
        User userSaved=null;
        user.setCreatedDate(new Date());
        userSaved=userRepository.save(user);
        if (userSaved != null) {
            return userSaved;
        } else {
            return userSaved;
        }
    }
}
