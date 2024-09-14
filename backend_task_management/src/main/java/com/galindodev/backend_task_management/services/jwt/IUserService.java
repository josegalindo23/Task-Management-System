package com.galindodev.backend_task_management.services.jwt;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService {

    UserDetailsService userDetailsService();
}
