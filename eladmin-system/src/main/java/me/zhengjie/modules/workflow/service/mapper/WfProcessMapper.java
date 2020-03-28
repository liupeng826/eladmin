package me.zhengjie.modules.workflow.service.mapper;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.modules.workflow.domain.WfProcess;
import me.zhengjie.modules.workflow.service.dto.WfProcessDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author peng
* @date 2020-03-28
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WfProcessMapper extends BaseMapper<WfProcessDto, WfProcess> {

}