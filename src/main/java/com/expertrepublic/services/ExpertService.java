package com.expertrepublic.services;

import com.expertrepublic.domain.Expert;
import com.expertrepublic.domain.ExpertAd;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ExpertService {

    public ResponseEntity<?> registerNewExpert(Expert expert);

    public ResponseEntity<?> addNewService(ExpertAd service);
}
