package me.zhengjie.modules.workflow.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author peng
 * @date 2020-03-28
 */
@Entity
@Data
@Table(name = "wf_process")
public class WfProcess implements Serializable {

    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 流程名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 流程显示名称
     */
    @Column(name = "display_Name")
    private String displayName;

    /**
     * 流程类型
     */
    @Column(name = "type")
    private String type;

    /**
     * 实例url
     */
    @Column(name = "instance_Url")
    private String instanceUrl;

    /**
     * 流程是否可用
     */
    @Column(name = "state")
    private Integer state;

    /**
     * 流程模型定义
     */
    @Column(name = "content")
    private byte[] content;

    /**
     * 版本
     */
    @Column(name = "version")
    private Integer version;

    /**
     * 创建时间
     */
    @Column(name = "create_Time", columnDefinition = "longblob", nullable = true)
    private String createTime;

    /**
     * 创建人
     */
    @Column(name = "creator")
    private String creator;

    public void copy(WfProcess source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
