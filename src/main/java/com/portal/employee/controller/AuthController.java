package com.portal.employee.controller;

import com.portal.employee.document.User;
import com.portal.employee.model.RegisterRequest;
import com.portal.employee.repository.UserRepo;
import com.portal.employee.util.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/portal")
public class AuthController {
    private final UserRepo userRepo;

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest){
        User user = User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(AuthUtil.encode(registerRequest.getPassword(), 12))
                .roles(registerRequest.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()))
                        .collect(Collectors.toList()))
                .build();
        userRepo.save(user);
        return new ResponseEntity("User with Username: "+registerRequest.getUsername()+" created successfully", HttpStatus.CREATED);
    }
}
