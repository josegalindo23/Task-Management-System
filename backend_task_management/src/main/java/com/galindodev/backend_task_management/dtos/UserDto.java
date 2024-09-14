package com.galindodev.backend_task_management.dtos;

import com.galindodev.backend_task_management.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
}
