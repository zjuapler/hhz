package com.apler.entity.question;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BestAnswer {
    private String content;
    private String username;
}
