package com.galindodev.backend_task_management.repositories;

import com.galindodev.backend_task_management.entities.User;
import com.galindodev.backend_task_management.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User>findFirstByEmail(String username);

    Optional<User> findByUserRole(UserRole userRole);
}
