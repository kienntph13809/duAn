package com.example.datn_2023.service;

import com.example.datn_2023.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.List;

public interface IImageService {
    //add image
    public Image addImage(Image image);
    //update image
    public Image updateImage(Long id, Image image);
    //delete image
    public boolean deleteImage(Long id);
    //getAllImage
    public List<Image> getAllImage();
    //getOneImage
    public Image getOneImage(Long id);

    List<String> uploads(MultipartFile[] files);

    void receiveFile(OutputStream out, String[] names);
}
