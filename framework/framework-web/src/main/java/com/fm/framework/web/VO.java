package com.fm.framework.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>值对象</p>
 *
 * @author clufeng
 */

@Data
public class VO {

    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime ts;

}
