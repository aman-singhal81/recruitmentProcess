package com.recruitment.process.controller;

import com.recruitment.process.model.OfferData;
import com.recruitment.process.pojo.Offer;
import com.recruitment.process.pojo.User;
import com.recruitment.process.repository.OfferRepository;
import com.recruitment.process.service.OfferService;
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
@RequestMapping("offer")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @Autowired
    private OfferRepository offerRepository;

    @PostMapping(value = "/create",consumes = "application/json")
    public ResponseEntity<Offer> createOffer(@RequestBody OfferData offer) {
        log.info("inside offer create contoller");
        if (offerService.saveOffer(offer)!=null) {
            return new ResponseEntity<Offer>(offerService.findOffer(offer.getJobTitle()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Offer>> getAll() {
        return new ResponseEntity<>(offerService.getAllOffer(), HttpStatus.OK);
    }

    @PostMapping(value = "/findOne", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Offer> findOne(@RequestBody String jobTitle) {
        JSONObject jsonObject=new JSONObject(jobTitle);
        log.info("jobTitle" + jobTitle);
        if (offerService.findOffer(jsonObject.getString("jobTitle")) != null) {
            return new ResponseEntity<Offer>(offerService.findOffer(jsonObject.getString("jobTitle")), HttpStatus.OK);
        } else {
            return new ResponseEntity<Offer>(HttpStatus.BAD_REQUEST);
        }
    }
}
