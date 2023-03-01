package com.example.datn_2023.controller;

import com.example.datn_2023.entity.Image;
import com.example.datn_2023.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     *
     * @param id: image id (if null or undefined -> add new image else update existed image)
     * @param image: request body
     * @return saved image
     */
    @PostMapping({"/save", "/save/{id}"})
    public ResponseEntity<Image> saveImage(@PathVariable(required = false) Long id, @RequestBody(required = false) Image image) {
        return ResponseEntity.ok(iImageService.saveImage(id, image));
    }

    //delete Image
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Image> deleteImage(@PathVariable("id") long id) {
        return ResponseEntity.ok(iImageService.deleteImage(id));
    }

    @GetMapping("/list")
    public List<Image> getAllImage() {
        return iImageService.getAllImage();
    }

    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploads(@RequestBody MultipartFile[] files) {
        List<String> lstImage = iImageService.uploads(files);
        if (lstImage.size() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(lstImage);
    }

    @GetMapping("/files/{names}")
    public StreamingResponseBody getFile(HttpServletResponse response, @PathVariable(required = false) String... names) {
        response.setContentType("image/jpg");
        return out -> iImageService.receiveFile(out, names);
    }
}
