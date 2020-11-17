package com.recruitment.process.controller;

import com.recruitment.process.pojo.Candidate;
import com.recruitment.process.pojo.User;
import com.recruitment.process.service.CandidateService;
import com.recruitment.process.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping("/create")
        public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
            if (candidateService.createCandidate(candidate)!=null) {
                return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
            } else {
                return new ResponseEntity<Candidate>(candidate, HttpStatus.BAD_REQUEST);
            }
    }

    @PostMapping("/ok")
    public ResponseEntity<String> createCandidate() {
        log.info("abcd");
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}

