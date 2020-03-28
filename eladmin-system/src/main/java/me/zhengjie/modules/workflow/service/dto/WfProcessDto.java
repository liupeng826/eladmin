package me.zhengjie.modules.workflow.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
* @author peng
* @date 2020-03-28
*/
@Data
public class WfProcessDto implements Serializable {

    /** 主键ID */
    private String id;

    /** 流程名称 */
    private String name;

    /** 流程显示名称 */
    private String displayName;

    /** 流程类型 */
    private String type;

    /** 实例url */
    private String instanceUrl;

    /** 流程是否可用 */
    private Integer state;

    /** 流程模型定义 */
    private byte[] content;

    /** 版本 */
    private Integer version;

    /** 创建时间 */
    private String createTime;

    /** 创建人 */
    private String creator;
}
