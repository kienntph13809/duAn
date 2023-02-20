package com.example.childrenwear.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String email;
    private String phone;
    @Column(name = "isDelete")
    private Boolean isDelete = false;
    @Column(name = "address")
    private String address;



}
