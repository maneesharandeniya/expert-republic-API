package com.expertrepublic.controllers;


import com.expertrepublic.dto.BookingDto;
import com.expertrepublic.services.ExpertAdService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-ad")
public class ExpertAdController {

    @Autowired
    private ExpertAdService expertAdService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllExpertsAdds() {
        ResponseEntity<?> response = expertAdService.getAllExpertsAdds();
        return response;
    }
}
