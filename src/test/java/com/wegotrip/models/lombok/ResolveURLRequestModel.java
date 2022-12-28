package com.wegotrip.models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResolveURLRequestModel {

    private String slug;
    private Boolean checkout;

}
