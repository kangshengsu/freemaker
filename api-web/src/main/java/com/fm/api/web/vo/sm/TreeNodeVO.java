package com.fm.api.web.vo.sm;

import lombok.Data;

import java.util.List;

/**
 * <p>类描述</p>
 *
 * @author hubo
 */
@Data
public class TreeNodeVO {

    private Long id;

    private String label;

    private int sq;

    private List<TreeNodeVO> children;

}
