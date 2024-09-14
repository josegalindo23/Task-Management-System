package com.galindodev.backend_task_management.services;

import com.galindodev.backend_task_management.dtos.SignUpRequest;
import com.galindodev.backend_task_management.dtos.UserDto;
import com.galindodev.backend_task_management.entities.User;
import com.galindodev.backend_task_management.enums.UserRole;
import com.galindodev.backend_task_management.repositories.IUserRepository;
import com.galindodev.backend_task_management.services.auth.IAuthService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final IUserRepository iUserRepository;

    @PostConstruct
    public void createAnAdminAccount(){
        Optional<User> optionalUser = iUserRepository.findByUserRole(UserRole.ADMIN);
        if(optionalUser.isEmpty()){
            User user = new User();
            user.setEmail(("admin@test.com"));
            user.setName("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user.setUserRole(UserRole.ADMIN);
            iUserRepository.save(user);
            System.out.println("Admin account created successfully");
        }else {
            System.out.println("Admin account already exist");
        }
    }

    @Override
    public UserDto signUpUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setName(signUpRequest.getName());
        user.setPassword(signUpRequest.getPassword());
        user.setUserRole(UserRole.EMPLOYEE);
        User createdUser = iUserRepository.save(user);
        return createdUser.getUserDTO();
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return iUserRepository.findFirstByEmail(email).isPresent();
    }
}
