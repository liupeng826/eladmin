package me.zhengjie.modules.workflow.rest;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.workflow.domain.Process;
import me.zhengjie.modules.workflow.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
@Api(tags = "工作流")
@RequestMapping("/api/workflow")
public class SnakerEngineController {
    @Autowired
    private ProcessService processService;

    @Log("查询流程")
    @ApiOperation("查询流程")
    @GetMapping(value = "/getProcessById")
    public ResponseEntity<Object> getProcessById(@RequestParam String id) {

        Process process = processService.getProcessById(id);
        return new ResponseEntity<>(JSONObject.toJSONString(process), HttpStatus.OK);
    }

    @Log("部署流程")
    @ApiOperation("部署流程")
    @GetMapping(value = "/deploy")
    public ResponseEntity<Object> deploy() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("flows/borrow.snaker");
        String deploy = processService.deploy(stream);
        return new ResponseEntity<>(deploy, HttpStatus.OK);
    }

}
