package com.galindodev.backend_task_management.services.auth;

import com.galindodev.backend_task_management.dtos.SignUpRequest;
import com.galindodev.backend_task_management.dtos.UserDto;

public interface IAuthService {
    UserDto signUpUser(SignUpRequest signUpRequest);
    boolean hasUserWithEmail(String email);
}
