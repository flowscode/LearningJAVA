package com.flowcode.coursecatalog.userobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigInteger;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public class User {
        private BigInteger userId;
        private BigInteger courseId;
        private String userName;
    }
