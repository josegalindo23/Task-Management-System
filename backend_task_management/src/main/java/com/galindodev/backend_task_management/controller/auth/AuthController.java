package com.galindodev.backend_task_management.controller.auth;

import com.galindodev.backend_task_management.dtos.SignUpRequest;
import com.galindodev.backend_task_management.dtos.UserDto;
import com.galindodev.backend_task_management.services.auth.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private  final IAuthService iauthService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpRequest signUpRequest){
        if(iauthService.hasUserWithEmail(signUpRequest.getEmail()))
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User already exist with this email");
        UserDto createdUserDto =  iauthService.signUpUser(signUpRequest);
        if (createdUserDto == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Not Created");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDto);
    }
}
