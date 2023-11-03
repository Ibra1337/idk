package com.example.idk.Controlers;


import com.example.idk.Models.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationDto {

    private String username;
    private String password;

    public RegistrationDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User toUser(PasswordEncoder encoder)
    {
        return new User(username , encoder.encode(password));
    }

    public String toString() {
        return "User:" + this.getUsername() + ", password=" + this.getPassword() + ")";
    }


}
