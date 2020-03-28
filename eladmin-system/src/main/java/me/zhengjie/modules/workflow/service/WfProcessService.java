package me.zhengjie.modules.workflow.service;

import me.zhengjie.modules.workflow.domain.WfProcess;
import me.zhengjie.modules.workflow.service.dto.WfProcessDto;
import me.zhengjie.modules.workflow.service.dto.WfProcessQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @author peng
* @date 2020-03-28
*/
public interface WfProcessService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(WfProcessQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<WfProcessDto>
    */
    List<WfProcessDto> queryAll(WfProcessQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return WfProcessDto
     */
    WfProcessDto findById(String id);

    /**
    * 创建
    * @param resources /
    * @return WfProcessDto
    */
    WfProcessDto create(WfProcess resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(WfProcess resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(String[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<WfProcessDto> all, HttpServletResponse response) throws IOException;
}