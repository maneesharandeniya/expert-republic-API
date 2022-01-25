package com.expertrepublic.services.impl;

import com.expertrepublic.domain.ExpertAd;
import com.expertrepublic.dto.ExpertAdCommonDto;
import com.expertrepublic.mapstruct.MapStructMapper;
import com.expertrepublic.repos.BookingRepo;
import com.expertrepublic.repos.ExpertAdRepo;
import com.expertrepublic.services.ExpertAdService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ExpertAdServiceImpl implements ExpertAdService {

    private final ExpertAdRepo expertAdRepo;

    private final BookingRepo bookingRepo;

    @Autowired
    MapStructMapper mapStructMapper;

    @Override
    public ResponseEntity<?> getAllExpertsAdds() {
        List<ExpertAd> expertAds = expertAdRepo.findAll();
        List<ExpertAdCommonDto> expertAdDtos = new ArrayList<>();

        for (ExpertAd ad: expertAds) {
            ExpertAdCommonDto adDto = mapStructMapper.expertAdToExpertAdCommonDto(ad);
            expertAdDtos.add(adDto);
        }
        return new ResponseEntity<>(expertAdDtos, HttpStatus.OK);
    }



}
