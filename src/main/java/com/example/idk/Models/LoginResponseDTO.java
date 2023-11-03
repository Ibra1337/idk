package com.example.idk.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponseDTO {
    private User user;
    private String jwt;

    public LoginResponseDTO(User user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }
}
