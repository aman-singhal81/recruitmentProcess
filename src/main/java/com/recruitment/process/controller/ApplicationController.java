package com.recruitment.process.controller;

import com.recruitment.process.model.ApplicationData;
import com.recruitment.process.pojo.Application;
import com.recruitment.process.service.ApplicationService;
import com.recruitment.process.service.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    CandidateService candidateService;

    @PostMapping(value = "/apply",consumes = "application/json")
    public ResponseEntity<Application> applyJob(@RequestBody ApplicationData application) {
        log.info("inside offer create contoller");
        if (applicationService.applyJob(application)!=null) {
            return new ResponseEntity<Application>(applicationService.findApplication(application.getJobTitle(),application.getEmail()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Application>> getAll() {
        return new ResponseEntity<>(applicationService.getAllApplication(), HttpStatus.OK);
    }

    @PostMapping(value = "/findOne", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Application> findOne(@RequestBody String jobTitleEmail) {
        JSONObject jsonObject=new JSONObject(jobTitleEmail);
        log.info("finding application for jobTitle,email" + jsonObject.getString("jobTitle") + jsonObject.getString("email"));
        if (applicationService.findApplication(jsonObject.getString("jobTitle"),jsonObject.getString("email")) != null) {
            return new ResponseEntity<Application>(applicationService.findApplication(jsonObject.getString("jobTitle"),jsonObject.getString("email")), HttpStatus.OK);
        } else {
            return new ResponseEntity<Application>( HttpStatus.BAD_REQUEST);
        }
    }
}
