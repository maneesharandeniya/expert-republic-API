package com.expertrepublic.services.impl;

import com.expertrepublic.controllers.LoginController;
import com.expertrepublic.domain.Expert;
import com.expertrepublic.domain.ExpertAd;
import com.expertrepublic.dto.ExpertAdExpertDto;
import com.expertrepublic.dto.ExpertAdPostDto;
import com.expertrepublic.dto.ExpertRegisterDto;
import com.expertrepublic.mapstruct.MapStructMapper;
import com.expertrepublic.repos.ExpertAdRepo;
import com.expertrepublic.repos.ExpertRepo;
import com.expertrepublic.services.CustomUserDetailsService;
import com.expertrepublic.services.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ExpertServiceImpl implements ExpertService {

    private final ExpertRepo expertRepo;

    private final ExpertAdRepo expertAdRepo;

    private final BCryptPasswordEncoder passwordEncoder;

    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    MapStructMapper mapStructMapper;

    @Override
    public ResponseEntity<?> registerNewExpert(ExpertRegisterDto regExpert) {
        try {
            final UserDetails userDetails = customUserDetailsService.loadUserByUsername(regExpert.getEmail());
            return new ResponseEntity<>("Email already in use.Try with a new one.", HttpStatus.BAD_REQUEST);
        }catch (UsernameNotFoundException e){
            Expert expert = mapStructMapper.expertRegisterDtoToExpert(regExpert);
            expert.setPassword(passwordEncoder.encode(expert.getPassword()));
            expertRepo.save(expert);
            return new ResponseEntity<>("Expert added successfully.", HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<?> addNewExpertAd(ExpertAdPostDto servicePost) {
        try {
            String userEmail = LoginController.getUserFromSession();
            if(userEmail == null){
                return new ResponseEntity<>("Email address not found.", HttpStatus.BAD_REQUEST);
            }
            Expert expert = expertRepo.findByEmail(userEmail);
            ExpertAd service = mapStructMapper.expertAdPostDtoToExpertAd(servicePost);
            service.setExpert(expert);
            expertAdRepo.save(service);
            return new ResponseEntity<>("Service added successfully", HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public ResponseEntity<?> getExpertsAds() {

        String userEmail = LoginController.getUserFromSession();
        if(userEmail == null){
            return new ResponseEntity<>("Email address not found.", HttpStatus.BAD_REQUEST);
        }
        Expert expert = expertRepo.findByEmail(userEmail);
        List<ExpertAdExpertDto> expertAdExpertDtoList = mapStructMapper.expertAdToExpertAdExpertDto(expert.getServicesAd());

        return new ResponseEntity<>(expertAdExpertDtoList, HttpStatus.OK);
    }
}
