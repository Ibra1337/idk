package com.example.idk.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Content {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long contentId;
    private String text;

    public Content( String text) {

        this.text = text;
    }
}
