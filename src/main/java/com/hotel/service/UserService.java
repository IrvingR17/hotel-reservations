package com.hotel.service;

import com.hotel.exception.UserAlreadyExistsException;
import com.hotel.exception.UserNotFoundException;
import com.hotel.repository.UserRepository;
import com.hotel.models.Users;
import com.hotel.record.UserRecord;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Users registerUser(Users user) {
        Optional<Users> theUser = userRepository.findByUsername(user.getUsername());
        if (theUser.isPresent()){
            throw new UserAlreadyExistsException("A user with username: " + user.getUsername() + " already exists");
        }
        theUser = userRepository.findByEmail(user.getEmail());
        if (theUser.isPresent()){
            throw new UserAlreadyExistsException("A user with email: " + user.getEmail() + " already exists");
        }

        user.setRoles("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<UserRecord> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserRecord(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getUsername())).collect(Collectors.toList());
    }

    public Users getUserByUsernameOrEmail(String usernameOrEmail) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UserNotFoundException("User not found with this username or email: " + usernameOrEmail));
    }

    @Transactional
    public void deleteUserByUsernameOrEmail(String usernameOrEmail) {
        Users user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UserNotFoundException("user not found"));

        userRepository.delete(user);
    }

}
