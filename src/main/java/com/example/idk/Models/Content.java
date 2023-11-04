package com.example.idk.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Content {

    @Id
    private Long contentId;
    private String text;



}
