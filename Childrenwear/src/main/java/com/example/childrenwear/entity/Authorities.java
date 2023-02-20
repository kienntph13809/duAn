package com.example.childrenwear.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "isDelete")
    private Boolean isDelete = false;
    @ManyToOne
    @JoinColumn(name = "idaccount")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "idrole")
    private Role role;

}
