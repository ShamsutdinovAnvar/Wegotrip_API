package com.wegotrip.models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DaysAvailableRequestModel {


    private String start;
    private String end;




}
