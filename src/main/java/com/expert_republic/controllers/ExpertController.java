package com.expert_republic.controllers;

import com.expert_republic.models.Expert;
import com.expert_republic.services.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/expert")
public class ExpertController {

    @Autowired
    private ExpertService expertService;

    @PostMapping("/signup")
    public ResponseEntity<?> expertRegistration(@RequestBody Expert expert) {
        ResponseEntity<?> response = expertService.registerNewExpert(expert);
        return response;
    }
}
