package com.expertrepublic.controllers;

import com.expertrepublic.dto.LoginRequest;
import com.expertrepublic.dto.LoginResponse;
import com.expertrepublic.services.CustomUserDetailsService;
import com.expertrepublic.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping(value = "/login" ,produces = {"application/json"})
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserEmail(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Incorrect userID or Password.", HttpStatus.BAD_REQUEST);
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUserEmail());
        final String jwtToken = jwtTokenUtil.generateToken(userDetails);
        System.out.println(jwtToken);
        Object[] roles = userDetails.getAuthorities().toArray();

        Map<String,String> payLoad = new HashMap();
        payLoad.put("token",jwtToken);
        payLoad.put("role",roles[0].toString());
       // payLoad.put("name",appUser.getName());

        return ResponseEntity.ok(new LoginResponse(payLoad));
    }

    public static String getUserFromSession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String userEmail = authentication.getName();
            return userEmail;
        }
        return null;
    }

}
