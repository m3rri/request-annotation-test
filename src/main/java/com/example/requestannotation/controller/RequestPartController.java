package com.example.requestannotation.controller;

import com.example.requestannotation.dto.RequestPartTest2Body;
import com.example.requestannotation.dto.RequestPartTestBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@RestController
@RequestMapping("/request-part")
public class RequestPartController {

    @PostMapping(value = "/single")
    public String single(@RequestPart(value = "file") MultipartFile file){
        return "request part single "+file.getOriginalFilename();
    }

    @PostMapping("/with-request-param")
    public String withRequestParam(@RequestPart MultipartFile file, @RequestParam String name){
        return "request part with request param "+file.getOriginalFilename()+"_"+name;
    }

    /**안됨 415*/
    @PostMapping("/with-request-body")
    public String withRequestBody(@RequestPart MultipartFile file, @RequestBody RequestPartTestBody requestBody){
        return "request part with request body "+file.getOriginalFilename()+"_"+requestBody.toString();
    }

    @PostMapping("/with-request-part")
    public String withRequestPart(@RequestPart MultipartFile file, @RequestPart RequestPartTestBody requestBody){
        return "request part with request part "+file.getOriginalFilename()+"_"+requestBody.toString();
    }

    /**안됨 400*/
    @PostMapping("/in-the-request-body")
    public String inTheRequestBody(@RequestPart RequestPartTest2Body requestBody){
        return "request part in the request body "+requestBody.toString();
    }
}
