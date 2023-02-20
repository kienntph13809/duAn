package com.example.childrenwear.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "property")
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "isDelete")
    private Boolean isDelete = false;
}
