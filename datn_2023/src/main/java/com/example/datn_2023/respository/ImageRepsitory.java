package com.example.datn_2023.respository;

import com.example.datn_2023.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepsitory extends JpaRepository<Image,Long> {
}
