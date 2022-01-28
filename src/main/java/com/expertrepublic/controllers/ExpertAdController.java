package com.expertrepublic.controllers;


import com.expertrepublic.services.ExpertAdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-ad")
@RequiredArgsConstructor
public class ExpertAdController {

    private final ExpertAdService expertAdService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllExpertsAdds() {
        ResponseEntity<?> response = expertAdService.getAllExpertsAdds();
        return response;
    }
}
