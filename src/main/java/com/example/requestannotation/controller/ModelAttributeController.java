package com.example.requestannotation.controller;

import com.example.requestannotation.dto.ModelAttributeTest2Body;
import com.example.requestannotation.dto.ModelAttributeTestBody;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/model-attribute")
public class ModelAttributeController {

    @PostMapping("/single")
    public String single(@ModelAttribute MultipartFile file){
        return "model attribute single "+file.getOriginalFilename();
    }

    /** 안됨 */
    @PostMapping("/with-request-body")
    public String withRequestBody(@ModelAttribute MultipartFile file, @RequestBody ModelAttributeTestBody requestBody){
        return "model attribute with request body "+file.getOriginalFilename()+"_"+requestBody.toString();
    }

    @PostMapping(value = "in-the-request-body", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String inTheRequestBody(@ModelAttribute ModelAttributeTest2Body requestBody){
        return "model attribute in the request body "+requestBody.toString();
    }
}
