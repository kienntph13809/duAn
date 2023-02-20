package com.example.childrenwear.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "wallet")
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double surplus; // số dư
    @Column(name = "isDelete")
    private Boolean isDelete = false;

}
