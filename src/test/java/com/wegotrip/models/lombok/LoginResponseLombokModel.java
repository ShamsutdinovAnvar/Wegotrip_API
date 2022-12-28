package com.wegotrip.models.lombok;

import lombok.Data;

@Data
public class LoginResponseLombokModel {
    // { "token": "QpwL5tke4Pnpja7X4" }

    private String token;
    private String type;
    private Integer id;


}
