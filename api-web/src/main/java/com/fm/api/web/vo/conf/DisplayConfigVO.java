package com.fm.api.web.vo.conf;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fm.framework.web.VO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author hubo
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class DisplayConfigVO extends VO {
    /**
     * 展现配置ID
     */
    private Long displayId;

    /**
     * 展现配置类型
     */
    private Integer displayType;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 权重
     */
    private Integer recommendWeight;

    /**
     * 是否开启IM
     */
    private Integer isShowIm;

    /**
     * 过期时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expiredTime;


    private final Map<String, String> attrs = new HashMap<>();

    public void addAttr(String key, String value) {
        if(Objects.nonNull(key)) {
            attrs.put(key, value);
        }
    }

}
