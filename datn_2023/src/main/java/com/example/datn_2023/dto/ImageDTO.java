package com.example.datn_2023.dto;


import com.example.datn_2023.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageDTO {
    private Long id;
    private String name;
    private String url;
    private Boolean isDelete = false;
    private Product product;
}
