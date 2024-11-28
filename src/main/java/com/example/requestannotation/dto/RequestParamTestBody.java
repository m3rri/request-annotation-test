package com.example.requestannotation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class RequestParamTestBody {
    private String name;
    private String desc;
}
