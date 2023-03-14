package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.models.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    
    Optional<Users> findByUsernameOrEmail(String username, String email);

    Optional<Users> findByUsername(String username);

    Optional<Users> findByEmail(String email);

    void deleteByUsernameOrEmail(String username, String email);
}
