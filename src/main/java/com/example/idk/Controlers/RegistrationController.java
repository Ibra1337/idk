package com.example.idk.Controlers;


import com.example.idk.Models.Role;
import com.example.idk.Models.User;
import com.example.idk.Repositories.RoleRepo;
import com.example.idk.Repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.Set;

@Controller
@Slf4j
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder encoder;

    public RegistrationController(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder encoder)
    {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
    }

    @GetMapping
    public String registerForm(){
        return "/register";
    }

    @PostMapping
    public String processRegistration(RegistrationDto form, RedirectAttributes redirectAttributes) {
        log.info(form.toString());
        var role = roleRepo.findByAuthority("ROLE_USER");

        Role r;
        if (role.isEmpty()) {
            r = new Role("ROLE_USER");
            roleRepo.save(r);
        } else {
            r = role.get();
        }
        var fromDb = userRepo.findByUsername(form.getUsername());
        if (fromDb.isEmpty()) {
            Set<Role> as = new HashSet<>();
            as.add(r);
            User u = form.toUser(encoder);
            u.setAuthorities(as);
            userRepo.save(u);

            return "redirect:/login";
        } else {
            redirectAttributes.addAttribute("error", "UsernameNotFound");
            return "redirect:/register";
        }
    }





}
