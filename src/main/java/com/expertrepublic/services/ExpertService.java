package com.expertrepublic.services;

import com.expertrepublic.domain.Expert;
import com.expertrepublic.domain.ExpertAd;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpertService {

    public ResponseEntity<?> registerNewExpert(Expert expert);

    public ResponseEntity<?> addNewExpertAd(ExpertAd service);

    public ResponseEntity<?> getExpertsAds();
}
