package com.recruitment.process.service;

import com.recruitment.process.model.OfferData;
import com.recruitment.process.pojo.Offer;
import com.recruitment.process.pojo.User;
import com.recruitment.process.repository.OfferRepository;
import com.recruitment.process.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    UserRepository userRepository;

    public Offer saveOffer(OfferData offer){
        log.info("Creating offer");
        Offer offersaved=new Offer();
        User user=userRepository.findByName(offer.getUserName());
        if(user!=null){
            offersaved.setUser(user);
        }else{
            return null;
        }
        offersaved.setStartDate(new Date());
        offersaved.setNumberOfApplication(0);
        offersaved.setJobTitle(offer.getJobTitle());
        offersaved=offerRepository.save(offersaved);
        return offersaved;
    }
    public Offer findOffer(String jobTitle) {
        log.info("find Offer");
        if (jobTitle != null && !jobTitle.equals("")) {
            Offer offer = offerRepository.findByjobTitle(jobTitle);
            if (offer != null) {
                return offer;
            } else {
                log.info("offer Does not Exist");
                return offer;
            }
        }

        return null;
    }
    public List<Offer> getAllOffer() {
        return offerRepository.findAll();
    }
}
