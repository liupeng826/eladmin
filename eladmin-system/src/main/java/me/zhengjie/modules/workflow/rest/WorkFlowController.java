package me.zhengjie.modules.workflow.rest;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.workflow.domain.WfProcess;
import me.zhengjie.modules.workflow.service.SnakerFlowService;
import me.zhengjie.modules.workflow.service.WfProcessService;
import me.zhengjie.modules.workflow.service.dto.WfProcessQueryCriteria;
import me.zhengjie.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author peng
 * @date 2020-03-28
 */
@Api(tags = "WorkFlowController管理")
@RestController
@RequestMapping(value = "/api/workflow", produces = "application/json;charset=UTF-8")
public class WorkFlowController {

    private final WfProcessService wfProcessService;

    @Autowired
    private SnakerFlowService snakerFlowService;

    public WorkFlowController(WfProcessService wfProcessService) {
        this.wfProcessService = wfProcessService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('wfProcess:list')")
    public void download(HttpServletResponse response, WfProcessQueryCriteria criteria) throws IOException {
        wfProcessService.download(wfProcessService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询WorkFlowController")
    @ApiOperation("查询WorkFlowController")
//    @PreAuthorize("@el.check('wfProcess:list')")
    @AnonymousAccess
    public ResponseEntity<Object> getWfProcesss(WfProcessQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(wfProcessService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @PostMapping
    @Log("新增WorkFlowController")
    @ApiOperation("新增WorkFlowController")
    @PreAuthorize("@el.check('wfProcess:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody WfProcess resources) {
        return new ResponseEntity<>(wfProcessService.create(resources), HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改WorkFlowController")
    @ApiOperation("修改WorkFlowController")
    @PreAuthorize("@el.check('wfProcess:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody WfProcess resources) {
        wfProcessService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除WorkFlowController")
    @ApiOperation("删除WorkFlowController")
    @PreAuthorize("@el.check('wfProcess:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody String[] ids) {
        wfProcessService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getProcessList")
    @Log("查询工作流")
    @ApiOperation("查询工作流")
//    @PreAuthorize("@el.check('wfprocess:list')")
    @AnonymousAccess
    public ResponseEntity<Object> getProcessList() {
        snakerFlowService.initFlows();
        List<Process> processList = snakerFlowService.getProcessList();
        return new ResponseEntity<>(JSON.toJSONString(processList), HttpStatus.OK);
    }
}
