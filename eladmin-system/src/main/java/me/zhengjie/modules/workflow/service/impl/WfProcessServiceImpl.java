package me.zhengjie.modules.workflow.service.impl;

import me.zhengjie.modules.workflow.domain.WfProcess;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import me.zhengjie.modules.workflow.repository.WfProcessRepository;
import me.zhengjie.modules.workflow.service.WfProcessService;
import me.zhengjie.modules.workflow.service.dto.WfProcessDto;
import me.zhengjie.modules.workflow.service.dto.WfProcessQueryCriteria;
import me.zhengjie.modules.workflow.service.mapper.WfProcessMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import cn.hutool.core.util.IdUtil;
// 默认不使用缓存
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
* @author peng
* @date 2020-03-28
*/
@Service
//@CacheConfig(cacheNames = "wfProcess")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class WfProcessServiceImpl implements WfProcessService {

    private final WfProcessRepository wfProcessRepository;

    private final WfProcessMapper wfProcessMapper;

    public WfProcessServiceImpl(WfProcessRepository wfProcessRepository, WfProcessMapper wfProcessMapper) {
        this.wfProcessRepository = wfProcessRepository;
        this.wfProcessMapper = wfProcessMapper;
    }

    @Override
    //@Cacheable
    public Map<String,Object> queryAll(WfProcessQueryCriteria criteria, Pageable pageable){
        Page<WfProcess> page = wfProcessRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(wfProcessMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<WfProcessDto> queryAll(WfProcessQueryCriteria criteria){
        return wfProcessMapper.toDto(wfProcessRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public WfProcessDto findById(String id) {
        WfProcess wfProcess = wfProcessRepository.findById(id).orElseGet(WfProcess::new);
        ValidationUtil.isNull(wfProcess.getId(),"WfProcess","id",id);
        return wfProcessMapper.toDto(wfProcess);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public WfProcessDto create(WfProcess resources) {
        resources.setId(IdUtil.simpleUUID()); 
        return wfProcessMapper.toDto(wfProcessRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(WfProcess resources) {
        WfProcess wfProcess = wfProcessRepository.findById(resources.getId()).orElseGet(WfProcess::new);
        ValidationUtil.isNull( wfProcess.getId(),"WfProcess","id",resources.getId());
        wfProcess.copy(resources);
        wfProcessRepository.save(wfProcess);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(String[] ids) {
        for (String id : ids) {
            wfProcessRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<WfProcessDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (WfProcessDto wfProcess : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("流程名称", wfProcess.getName());
            map.put("流程显示名称", wfProcess.getDisplayName());
            map.put("流程类型", wfProcess.getType());
            map.put("实例url", wfProcess.getInstanceUrl());
            map.put("流程是否可用", wfProcess.getState());
            map.put("流程模型定义", wfProcess.getContent());
            map.put("版本", wfProcess.getVersion());
            map.put("创建时间", wfProcess.getCreateTime());
            map.put("创建人", wfProcess.getCreator());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}