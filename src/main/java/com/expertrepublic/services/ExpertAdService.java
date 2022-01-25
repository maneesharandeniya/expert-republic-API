package com.expertrepublic.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ExpertAdService {

    public ResponseEntity<?> getAllExpertsAdds();


}
