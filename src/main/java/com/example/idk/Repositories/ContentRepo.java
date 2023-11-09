package com.example.idk.Repositories;

import com.example.idk.Models.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ContentRepo extends JpaRepository<Content , Long> {
}
