package com.example.childrenwear.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "size")
public class Size implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "isDelete")
    private Boolean isDelete = false;
    @ManyToOne
    @JoinColumn(name = "idtypesize", updatable = false, insertable = false)
    private TypeSize typesize;

    @Column(name = "idtypesize")
    private Long idtypesize;
    @JsonIgnore
    @OneToMany(mappedBy = "size")
    private List<Quantity> quantities;
}
