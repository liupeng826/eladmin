package me.zhengjie.modules.workflow.service;

import org.snaker.engine.access.Page;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Surrogate;
import org.snaker.engine.entity.Task;
import org.snaker.engine.entity.Process;

import java.util.List;
import java.util.Map;

/**
 * @author peng
 */
public interface SnakerFlowService {

    public void initFlows();

    /**
     * 得到所有流程定义的名称
     *
     * @return
     */
    public List<String> getAllProcessNames();

    public Order startInstanceById(String processId, String operator, Map<String, Object> args);

    public Order startInstanceByName(String name, Integer version, String operator, Map<String, Object> args);

    public Order startAndExecute(String name, Integer version, String operator, Map<String, Object> args);

    public Order startAndExecute(String processId, String operator, Map<String, Object> args);

    public List<Task> execute(String taskId, String operator, Map<String, Object> args);

    public List<Task> executeAndJump(String taskId, String operator, Map<String, Object> args, String nodeName);

    public List<Task> transferMajor(String taskId, String operator, String... actors);

    public List<Task> transferAidant(String taskId, String operator, String... actors);

    public Map<String, Object> flowData(String orderId, String taskName);

    public void addSurrogate(Surrogate entity);

    public void deleteSurrogate(String id);

    public Surrogate getSurrogate(String id);

    public List<Surrogate> searchSurrogate(Page<Surrogate> page, QueryFilter filter);

    public List<Process> getProcess(String orderId);

    public List<Process> getProcessList();

}
