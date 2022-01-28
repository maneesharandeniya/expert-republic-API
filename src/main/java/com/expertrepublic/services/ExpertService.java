package com.expertrepublic.services;

import com.expertrepublic.domain.ExpertAd;
import com.expertrepublic.dto.ExpertAdPostDto;
import com.expertrepublic.dto.ExpertRegisterDto;
import org.springframework.http.ResponseEntity;


public interface ExpertService {

    public ResponseEntity<?> registerNewExpert(ExpertRegisterDto expert);

    public ResponseEntity<?> addNewExpertAd(ExpertAdPostDto service);

    public ResponseEntity<?> getExpertsAds();
}
