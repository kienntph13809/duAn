package com.example.datn_2023.service;

import com.example.datn_2023.dto.ImageDTO;
import com.example.datn_2023.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.List;

public interface IImageService {
    //delete image
    List<ImageDTO> deleteImageByProduct(ImageDTO productId);

    //getAllImage
    List<ImageDTO> getAllImage();

    //getOneImage
    ImageDTO getOneImage(Long id);

    List<String> uploads(MultipartFile[] files);

    void receiveFile(OutputStream out, String[] names);

    @Deprecated
    Image saveImage(ImageDTO image);

    Image saveImage(MultipartFile file, ImageDTO image);
}
