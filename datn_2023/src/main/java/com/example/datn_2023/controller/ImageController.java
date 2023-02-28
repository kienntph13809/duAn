package com.example.datn_2023.controller;

import com.example.datn_2023.entity.Image;
import com.example.datn_2023.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private IImageService iImageService;

    @GetMapping("/")
    public String test() {
        return "vmh o day";
    }

    //add Image
    @PostMapping("/add")
    public Image addImage(@RequestBody Image image) {
        return iImageService.addImage(image);
    }

    //update Image
    @PutMapping("/update")
    public Image updateImage(@RequestParam("id") long id, @RequestBody Image image) {
        return iImageService.updateImage(id, image);
    }

    //delete Image
    @DeleteMapping("/delete/{id}")
    public boolean deleteImage(@PathVariable("id") long id) {
        return iImageService.deleteImage(id);
    }

    @GetMapping("/list")
    public List<Image> getAllImage() {
        return iImageService.getAllImage();
    }

    @PostMapping("/upload")
    public List<String> uploads(@RequestBody MultipartFile[] files) {
        return iImageService.uploads(files);
    }

    @GetMapping("/files/{names}")
    public StreamingResponseBody getFile(HttpServletResponse response, @PathVariable(required = false) String... names) {
        response.setContentType("image/jpg");
        return out -> iImageService.receiveFile(out, names);
    }
}
