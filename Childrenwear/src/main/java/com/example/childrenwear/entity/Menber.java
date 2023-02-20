package com.example.childrenwear.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")

@Data
@Entity
@Table(name = "menber")
public class Menber  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double sumcore;

}
