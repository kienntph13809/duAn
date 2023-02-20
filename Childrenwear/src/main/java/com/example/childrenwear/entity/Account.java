package com.example.childrenwear.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String email;
    private  String username;
    private  String password;
    private  String phone;
    @Column(name = "isDelete")
    private Boolean isDelete = false;
    @Column(name = "one_time_password")
    private String oneTimePassword;

    @Column(name = "otp_requested_time")
    private Date otpRequestedTime = new Date();
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Authorities> authorities;

}
