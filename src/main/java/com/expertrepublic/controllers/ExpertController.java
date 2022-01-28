package com.expertrepublic.controllers;

import com.expertrepublic.domain.ExpertAd;
import com.expertrepublic.dto.ExpertAdPostDto;
import com.expertrepublic.dto.ExpertRegisterDto;
import com.expertrepublic.services.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/expert")
@RequiredArgsConstructor
public class ExpertController {

    private final ExpertService expertService;

    @PostMapping("/signup")
    public ResponseEntity<?> expertRegistration(@Valid @RequestBody ExpertRegisterDto expert) {
        ResponseEntity<?> response = expertService.registerNewExpert(expert);
        return response;
    }


    @PostMapping("{expertId}/new-service")
    public ResponseEntity<?> addExpertAd(@Valid @RequestBody ExpertAdPostDto service) {
        ResponseEntity<?> response = expertService.addNewExpertAd(service);
        return response;
    }

    @GetMapping("{expertId}/all-services")
    public ResponseEntity<?> getExpertsAds() {
        ResponseEntity<?> response = expertService.getExpertsAds();
        return response;
    }


}
