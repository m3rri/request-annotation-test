package com.example.requestannotation.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class RequestPartTest2Body {
    private String name;
    private String desc;
    private MultipartFile file;

    public String toString(){
        return "{"+
                "\"name\":"+name+
                "\"desc\":"+desc+
                "\"file\":"+file.getOriginalFilename();
    }
}
