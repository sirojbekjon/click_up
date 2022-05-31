package com.example.clickup.controller;

import com.example.clickup.entity.User;
import com.example.clickup.payload.ApiResponse;
import com.example.clickup.payload.LoginDto;
import com.example.clickup.payload.RegisterDto;
import com.example.clickup.security.JwtProvider;
import com.example.clickup.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    AuthService authService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public HttpEntity<?> registerUser(@Valid @RequestBody RegisterDto registerDto){
            ApiResponse apiResponse = authService.registerUser(registerDto);
            return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }


    @PostMapping("/login")
    public HttpEntity<?> loginUser(@Valid @RequestBody LoginDto loginDto){
        try{

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()
        ));

            User user = (User)authenticate.getPrincipal();
        String token = jwtProvider.generateToken(user.getEmail());
        return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.ok(new ApiResponse("Parol yoki login hatoo",false));
    }
    }

    @PutMapping("/verifyEmail")
    public HttpEntity<?> verifyEmail(@RequestParam String email,@RequestParam String emailCode){
        ApiResponse apiResponse = authService.verifyEmail(email, emailCode);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);

    }




}
