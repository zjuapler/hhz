package com.apler.vo.photo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class PhotoWithType {
    private int type;
    private Photo photo;
}
