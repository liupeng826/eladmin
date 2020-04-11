package me.zhengjie.modules.workflow.service.impl;

import me.zhengjie.modules.workflow.model.*;
import me.zhengjie.modules.workflow.service.*;
import lombok.extern.slf4j.Slf4j;
import me.zhengjie.modules.workflow.service.SnakerEngine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author peng
 */
@Slf4j
@Service
//@CacheConfig(cacheNames = "dept")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SnakerEngineImpl implements SnakerEngine {

    /**
     * 流程定义业务类
     */
    protected ProcessServiceImpl processService;
    /**
     * 流程实例业务类
     */
    protected OrderServiceImpl orderService;
    /**
     * 任务业务类
     */
    protected TaskServiceImpl taskService;
    /**
     * 查询业务类
     */
    protected QueryServiceImpl queryService;
    /**
     * 管理业务类
     */
    protected ManagerServiceImpl managerService;

    public SnakerEngineImpl(ProcessServiceImpl process) {
        this.processService = process;
    }

//    /**
//     * 根据流程定义ID启动流程实例
//     */
//    @Override
//    public Order startInstanceById(String id) {
//        return startInstanceById(id, null, null);
//    }
//
//    /**
//     * 根据流程定义ID，操作人ID启动流程实例
//     */
//    @Override
//    public Order startInstanceById(String id, String operator) {
//        return startInstanceById(id, operator, null);
//    }
//
//    /**
//     * 根据流程定义ID，操作人ID，参数列表启动流程实例
//     */
//    @Override
//    public Order startInstanceById(String id, String operator, Map<String, Object> args) {
//        if (args == null) {
//            args = new HashMap<String, Object>();
//        }
//        Process process = processService.getProcessById(id);
//        processService.check(process, id);
//        Execution execution = execute(process, operator, args, null, null);
//
//        if (process.getModel() != null) {
//            StartModel start = process.getModel().getStart();
//            if (start != null) {
//                start.execute(execution);
//            }
//        }
//        return execution.getOrder();
//    }
//
//    /**
//     * 根据流程名称启动流程实例
//     *
//     * @since 1.3
//     */
//    @Override
//    public Order startInstanceByName(String name) {
//        return startInstanceByName(name, null, null, null);
//    }
//
//    /**
//     * 根据流程名称、版本号启动流程实例
//     *
//     * @since 1.3
//     */
//    @Override
//    public Order startInstanceByName(String name, Integer version) {
//        return startInstanceByName(name, version, null, null);
//    }
//
//    /**
//     * 根据流程名称、版本号、操作人启动流程实例
//     *
//     * @since 1.3
//     */
//    @Override
//    public Order startInstanceByName(String name, Integer version,
//                                     String operator) {
//        return startInstanceByName(name, version, operator, null);
//    }
//
//    /**
//     * 根据流程名称、版本号、操作人、参数列表启动流程实例
//     *
//     * @since 1.3
//     */
//    @Override
//    public Order startInstanceByName(String name, Integer version,
//                                     String operator, Map<String, Object> args) {
//        if (args == null) args = new HashMap<String, Object>();
//        Process process = processService.getProcessByVersion(name, version);
//        processService.check(process, name);
//        Execution execution = execute(process, operator, args, null, null);
//
//        if (process.getModel() != null) {
//            StartModel start = process.getModel().getStart();
//            AssertHelper.notNull(start, "指定的流程定义[name=" + name + ", version=" + version + "]没有开始节点");
//            start.execute(execution);
//        }
//
//        return execution.getOrder();
//    }
//
//    /**
//     * 根据父执行对象启动子流程实例（用于启动子流程）
//     */
//    @Override
//    public Order startInstanceByExecution(Execution execution) {
//        Process process = execution.getProcess();
//        StartModel start = process.getModel().getStart();
//        AssertHelper.notNull(start, "流程定义[id=" + process.getId() + "]没有开始节点");
//
//        Execution current = execute(process, execution.getOperator(), execution.getArgs(),
//                execution.getParentOrder().getId(), execution.getParentNodeName());
//        start.execute(current);
//        return current.getOrder();
//    }
//
//    /**
//     * 创建流程实例，并返回执行对象
//     *
//     * @param process        流程定义
//     * @param operator       操作人
//     * @param args           参数列表
//     * @param parentId       父流程实例id
//     * @param parentNodeName 启动子流程的父流程节点名称
//     * @return Execution
//     */
//    private Execution execute(Process process, String operator, Map<String, Object> args,
//                              String parentId, String parentNodeName) {
//        Order order = orderService.createOrder(process, operator, args, parentId, parentNodeName);
//        log.debug("创建流程实例对象:" + order);
//        Execution current = new Execution(this, process, order, args);
//        current.setOperator(operator);
//        return current;
//    }
//
//    /**
//     * 根据任务主键ID执行任务
//     */
//    @Override
//    public List<Task> executeTask(String taskId) {
//        return executeTask(taskId, null);
//    }
//
//    /**
//     * 根据任务主键ID，操作人ID执行任务
//     */
//    @Override
//    public List<Task> executeTask(String taskId, String operator) {
//        return executeTask(taskId, operator, null);
//    }
//
//    /**
//     * 根据任务主键ID，操作人ID，参数列表执行任务
//     */
//    @Override
//    public List<Task> executeTask(String taskId, String operator, Map<String, Object> args) {
//        //完成任务，并且构造执行对象
//        Execution execution = execute(taskId, operator, args);
//        if (execution == null) {
//            return Collections.emptyList();
//        }
//        ProcessModel model = execution.getProcess().getModel();
//        if (model != null) {
//            NodeModel nodeModel = model.getNode(execution.getTask().getTaskName());
//            //将执行对象交给该任务对应的节点模型执行
//            nodeModel.execute(execution);
//        }
//        return execution.getTasks();
//    }
//
//    /**
//     * 根据任务主键ID，操作人ID，参数列表执行任务，并且根据nodeName跳转到任意节点
//     * 1、nodeName为null时，则驳回至上一步处理
//     * 2、nodeName不为null时，则任意跳转，即动态创建转移
//     */
//    @Override
//    public List<Task> executeAndJumpTask(String taskId, String operator, Map<String, Object> args, String nodeName) {
//        Execution execution = execute(taskId, operator, args);
//        if (execution == null) {
//            return Collections.emptyList();
//        }
//        ProcessModel model = execution.getProcess().getModel();
//        AssertHelper.notNull(model, "当前任务未找到流程定义模型");
//        if (StringHelper.isEmpty(nodeName)) {
//            Task newTask = taskService.rejectTask(model, execution.getTask());
//            execution.addTask(newTask);
//        } else {
//            NodeModel nodeModel = model.getNode(nodeName);
//            AssertHelper.notNull(nodeModel, "根据节点名称[" + nodeName + "]无法找到节点模型");
//            //动态创建转移对象，由转移对象执行execution实例
//            TransitionModel tm = new TransitionModel();
//            tm.setTarget(nodeModel);
//            tm.setEnabled(true);
//            tm.execute(execution);
//        }
//
//        return execution.getTasks();
//    }
//
//    /**
//     * 根据流程实例ID，操作人ID，参数列表按照节点模型model创建新的自由任务
//     */
//    @Override
//    public List<Task> createFreeTask(String orderId, String operator, Map<String, Object> args, TaskModel model) {
//        Order order = queryService.getOrder(orderId);
//        AssertHelper.notNull(order, "指定的流程实例[id=" + orderId + "]已完成或不存在");
//        order.setLastUpdator(operator);
//        order.setLastUpdateTime(DateHelper.getTime());
//        Process process = processService.getProcessById(order.getProcessId());
//        Execution execution = new Execution(this, process, order, args);
//        execution.setOperator(operator);
//        return taskService.createTask(model, execution);
//    }
//
//    /**
//     * 根据任务主键ID，操作人ID，参数列表完成任务，并且构造执行对象
//     *
//     * @param taskId   任务id
//     * @param operator 操作人
//     * @param args     参数列表
//     * @return Execution
//     */
//    private Execution execute(String taskId, String operator, Map<String, Object> args) {
//        if (args == null) {
//            args = new HashMap<String, Object>();
//        }
//        Task task = taskService.complete(taskId, operator, args);
//        if (log.isDebugEnabled()) {
//            log.debug("任务[taskId=" + taskId + "]已完成");
//        }
//        Order order = queryService.getOrder(task.getOrderId());
//        AssertHelper.notNull(order, "指定的流程实例[id=" + task.getOrderId() + "]已完成或不存在");
//        order.setLastUpdator(operator);
//        order.setLastUpdateTime(DateHelper.getTime());
//        orderService.updateOrder(order);
//        //协办任务完成不产生执行对象
//        if (!task.isMajor()) {
//            return null;
//        }
//        Map<String, Object> orderMaps = order.getVariableMap();
//        if (orderMaps != null) {
//            for (Map.Entry<String, Object> entry : orderMaps.entrySet()) {
//                if (args.containsKey(entry.getKey())) {
//                    continue;
//                }
//                args.put(entry.getKey(), entry.getValue());
//            }
//        }
//        Process process = processService.getProcessById(order.getProcessId());
//        Execution execution = new Execution(this, process, order, args);
//        execution.setOperator(operator);
//        execution.setTask(task);
//        return execution;
//    }

}
