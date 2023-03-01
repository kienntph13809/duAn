package com.example.datn_2023.service;

import com.example.datn_2023.config.exception.ErrorCode;
import com.example.datn_2023.config.exception.ServerException;
import com.example.datn_2023.entity.Image;
import com.example.datn_2023.respository.ImageRepsitory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ImageServiceImplements implements IImageService {
    @Autowired
    private ImageRepsitory imageRepsitory;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public Image saveImage(Long id, Image image) {
        if (image == null) {
            throw new ServerException("No body", HttpStatus.BAD_REQUEST);
        }
        return imageRepsitory
                .findById(id == null ? -1 : id)
                .map(img -> {
                    img.setIsDelete(image.getIsDelete());
                    img.setName(image.getName());
                    img.setUrl(image.getUrl());
                    img.setProduct(image.getProduct());
                    return imageRepsitory.save(img);
                })
                .orElseGet(() -> imageRepsitory.save(image));
    }

    @Override
    public Image deleteImage(Long id) {
        return imageRepsitory
                .findById(id)
                .map(img -> {
                    img.setIsDelete(true);
                    return imageRepsitory.save(img);
                })
                .orElseGet(() -> null);
    }

    @Override
    public List<Image> getAllImage() {
        return imageRepsitory.findAll();
    }

    @Override
    public Image getOneImage(Long id) {
        return imageRepsitory
                .findById(id)
                .orElseThrow(() -> new ServerException("Image not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<String> uploads(MultipartFile[] files) {
        return Arrays.stream(files)
                .map(this::saveFileToDisk)
                .collect(Collectors.toList());
    }

    private String saveFileToDisk(MultipartFile file) {
        Path filePath = Paths.get(uploadDir).resolve(Objects.requireNonNull(file.getOriginalFilename()));
        if (Files.exists(filePath)) {
            return filePath.getFileName().toString();
        }

        try {
            Files.createDirectories(filePath.getParent());
            Files.copy(file.getInputStream(), filePath);
            return filePath.getFileName().toString();
        } catch (IOException e) {
            log.error("Error handle upload file: ", e);
        }

        return "";
    }

    public void receiveFile(OutputStream out, String... fileNames) {
        String fullPath = uploadDir + "/" + String.join("/", fileNames);
        ;
        try {
            this.writeToByte(out, fullPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToByte(OutputStream out, String path) throws IOException {
        File fi = new File(path);
        byte[] fileContent = Files.readAllBytes(fi.toPath());
        int offset = 0,
                chunkLength = 100,
                fileContentLength = fileContent.length;

        while (offset + chunkLength < fileContentLength) {
            out.write(fileContent, offset, chunkLength);
            out.flush();
            offset = offset + chunkLength;

            if (fileContentLength < offset + chunkLength) {
                chunkLength = fileContentLength - offset;
            }
        }
        out.close();
    }
}
