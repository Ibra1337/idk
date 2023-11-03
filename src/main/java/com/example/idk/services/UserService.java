package com.example.idk.services;

import com.example.idk.Models.User;
import com.example.idk.Repositories.RoleRepo;
import com.example.idk.Repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    private final PasswordEncoder encoder;
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;

    public UserService(PasswordEncoder encoder, RoleRepo roleRepo, UserRepo userRepo) {
        this.encoder = encoder;
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username: " + username);
        Optional<User> u = userRepo.findByUsername(username);
        if (u.isEmpty()) {
            log.info("invalid login atemp");
            throw new UsernameNotFoundException("user: " + username + " notfound");
        }
        log.info("successful login " + u.get().getPassword());

        return u.get();
    }
}
