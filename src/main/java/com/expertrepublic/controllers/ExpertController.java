package com.expertrepublic.controllers;

import com.expertrepublic.domain.Expert;
import com.expertrepublic.domain.ExpertAd;
import com.expertrepublic.services.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/expert")
@RequiredArgsConstructor
public class ExpertController {

    private final ExpertService expertService;

    @PostMapping("/signup")
    public ResponseEntity<?> expertRegistration(@RequestBody Expert expert) {
        ResponseEntity<?> response = expertService.registerNewExpert(expert);
        return response;
    }


    @PostMapping("/add/service")
    public ResponseEntity<?> addNewService(@RequestBody ExpertAd service) {
        ResponseEntity<?> response = expertService.addNewService(service);
        return response;
    }

}
