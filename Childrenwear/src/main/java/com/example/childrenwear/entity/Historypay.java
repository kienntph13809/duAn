package com.example.childrenwear.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "history_pay")
public class Historypay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String amuos;// số tiền giao dịch
    private Double surplus;//số dư ví
    private String description;// nội dung giao dịch
    private String Content;//nạp tiền vào ví
    private Long trading_code; //mã giao dịch
    private Boolean status;
    private Date time;
}
