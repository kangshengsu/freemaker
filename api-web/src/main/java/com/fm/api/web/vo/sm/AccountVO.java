package com.fm.api.web.vo.sm;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>账号VO</p>
 *
 * @author hubo
 */
@Data
public class AccountVO {

    private Long id;

    /**
     * 账号名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
