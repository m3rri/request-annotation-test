package com.example.requestannotation.controller;

import com.example.requestannotation.dto.RequestParamTest2Body;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/request-param")
public class RequestParamController {

    @PostMapping("/single")
    public String singleRequest(@RequestParam MultipartFile file){
        return "request param single "+file.getOriginalFilename();
    }

    @PostMapping("/with-other-params")
    public String withOtherParamsRequest(@RequestParam MultipartFile file, @RequestParam String name){
        return "request param with other params "+file.getOriginalFilename()+"_"+name;
    }

    @PostMapping("/multi-with-other-params")
    public String withOtherParamsRequest(@RequestParam MultipartFile file1, @RequestParam MultipartFile file2, @RequestParam String name, @RequestParam String desc){
        return "request param with other params "+file1.getOriginalFilename()+"_"+file2.getOriginalFilename()+
                "_"+name+"_"+desc;
    }

    /**
     * 안됨 415
     */
    @PostMapping(value = "/with-request-body", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String withRequestBody(@RequestParam MultipartFile file, @RequestBody RequestParamTest2Body requestBody){
        return "request param with request body "+file.getOriginalFilename()+"_"+requestBody.toString();
    }
}
