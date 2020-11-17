package com.recruitment.process.service;

import com.recruitment.process.enums.ApplicationStatus;
import com.recruitment.process.model.ApplicationData;
import com.recruitment.process.pojo.Application;
import com.recruitment.process.pojo.Candidate;
import com.recruitment.process.pojo.Offer;
import com.recruitment.process.repository.ApplicationRepository;
import com.recruitment.process.repository.CandidateRepository;
import com.recruitment.process.repository.OfferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    CandidateRepository candidateRepository;


    public Application applyJob(ApplicationData application){
        log.info("Applying for Job");
        Application applicationsaved=new Application();
        applicationsaved.setApplicationStatus(ApplicationStatus.INVITED);
        Candidate candidate=candidateRepository.findByEmail(application.getEmail());
        if(candidate!=null){
            applicationsaved.setEmail(application.getEmail());
            applicationsaved.setCandidate(candidate);
        }else{
            return applicationsaved;
        }
        Offer offer=offerRepository.findByjobTitle(application.getJobTitle());
        if(offer!=null){
            offerRepository.setNumberOfApplication(offerRepository.findByjobTitle(application.getJobTitle()).getNumberOfApplication()+1,application.getJobTitle());
            applicationsaved.setOffer(offer);
        }else{
            return applicationsaved;
        }
        applicationsaved.setEmail(application.getEmail());
        applicationsaved.setResume(application.getResume());
        applicationsaved=applicationRepository.save(applicationsaved);
        if(applicationsaved!=null){
            return applicationsaved;
        }
        return applicationsaved;
    }
    public List<Application> getAllApplication() {
        return applicationRepository.findAll();
    }

    public Application findApplication(String JobTitle,String email){
        if(offerRepository.findByjobTitle(JobTitle)!=null){
            Application application=applicationRepository.findByOfferIdEmail(email);
            if(application!=null){
                return application;
            }else{
                log.info("Application Does not Exist");
                return application;
            }
        }else{
            log.info("offer Does not Exist");
            return null;
        }
    }
}
