package com.fm.api.gw.vo;

import com.fm.business.base.model.AttachmentInfo;
import com.fm.framework.core.model.ITreeNode;
import com.fm.framework.web.VO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class JobCateVO extends VO implements ITreeNode, Serializable {
    /**
     * 逻辑主键
     **/
    private Long id;


    /**
     *
     **/
    private String cateName;


    /**
     *
     **/
    private String cateCode;


    /**
     *
     **/
    private Integer cateType;


    /**
     *
     **/
    private String treeCode;


    /**
     *
     **/
    private Long parentId;

    /**
     * 附件
     */
    private transient List<AttachmentInfo> attachmentInfos;


    /**
     * 创建时间
     **/
    private Date createTime;


    /**
     * 修改时间
     **/
    private Date updateTime;


    /**
     * 创建人
     **/
    private String createUser;


    /**
     * 修改人
     **/
    private String updateUser;

    @Override
    public Long getNodeId() {
        return id;
    }

    @Override
    public String getParentCode() {
        return null;
    }

    @Override
    public String getIncode() {
        return treeCode;
    }

    @Override
    public void setIncode(String incode) {
        this.treeCode = incode;
    }
}
