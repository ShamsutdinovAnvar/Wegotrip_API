package com.wegotrip.models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResolveURLResponseModel {

    private Data data;
    @lombok.Data
    public static class Data {
        private String url;
    }
}