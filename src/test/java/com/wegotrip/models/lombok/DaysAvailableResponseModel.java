package com.wegotrip.models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DaysAvailableResponseModel {


    public List<AvailableDay> data;

    @lombok.Data
    public static class AvailableDay {
        private String status;
        private Boolean available;
        private Date date;

        @lombok.Data
        public static class Date {
            public Integer day;
            public Integer year;
            public Integer month;
        }
    }
}

