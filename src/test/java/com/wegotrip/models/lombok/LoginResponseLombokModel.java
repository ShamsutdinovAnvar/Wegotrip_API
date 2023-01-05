package com.wegotrip.models.lombok;

import lombok.Data;

@Data
public class LoginResponseLombokModel {

    private String token;
    private String type;
    private Integer id;
}
