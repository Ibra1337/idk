package com.example.idk.services;

import com.example.idk.Models.LoginResponseDTO;
import com.example.idk.Models.Role;
import com.example.idk.Models.User;
import com.example.idk.Repositories.RoleRepo;
import com.example.idk.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    private final UserRepo userRepo;

    private final RoleRepo roleRepo;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;



    public AuthenticationService(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;

    }

    public User registerUser(String username, String password){

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepo.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return userRepo.save(new User(0, username, encodedPassword, authorities));
    }



}
