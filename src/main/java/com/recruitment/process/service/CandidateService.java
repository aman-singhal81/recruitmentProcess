package com.recruitment.process.service;

import com.recruitment.process.pojo.Candidate;
import com.recruitment.process.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate createCandidate(Candidate candidate) {
        log.info("Saving candidate");
        Candidate candidatesaved=null;
        candidatesaved=candidateRepository.save(candidate);
        if (candidatesaved != null) {
            return candidatesaved;
        } else {
            return candidatesaved;
        }
    }
}
