package me.zhengjie.modules.workflow.service;

import me.zhengjie.modules.workflow.domain.*;

/**
 * 流程实例业务类
 *
 * @author yuqs
 * @since 1.0
 */
public interface OrderService {
//    /**
//     * 根据流程、操作人员、父流程实例ID创建流程实例
//     *
//     * @param process  流程定义对象
//     * @param operator 操作人员ID
//     * @param args     参数列表
//     * @return Order 活动流程实例对象
//     */
//    Order createOrder(Process process, String operator, Map<String, Object> args);
//
//    /**
//     * 根据流程、操作人员、父流程实例ID创建流程实例
//     *
//     * @param process        流程定义对象
//     * @param operator       操作人员ID
//     * @param args           参数列表
//     * @param parentId       父流程实例ID
//     * @param parentNodeName 父流程节点模型
//     * @return 活动流程实例对象
//     */
//    Order createOrder(Process process, String operator, Map<String, Object> args, String parentId, String parentNodeName);
//
//    /**
//     * 向指定实例id添加全局变量数据
//     *
//     * @param orderId 实例id
//     * @param args    变量数据
//     */
//    void addVariable(String orderId, Map<String, Object> args);
//
//    /**
//     * 创建抄送实例
//     *
//     * @param orderId  流程实例id
//     * @param actorIds 参与者id
//     * @since 1.5
//     */
//    void createCCOrder(String orderId, String... actorIds);
//
//    /**
//     * 流程实例正常完成
//     *
//     * @param orderId 流程实例id
//     */
//    void complete(String orderId);
//
//    /**
//     * 保存流程实例
//     *
//     * @param order 流程实例对象
//     */
//    void saveOrder(Order order);
//
//    /**
//     * 流程实例强制终止
//     *
//     * @param orderId 流程实例id
//     */
//    void terminate(String orderId);
//
//    /**
//     * 流程实例强制终止
//     *
//     * @param orderId  流程实例id
//     * @param operator 处理人员
//     */
//    void terminate(String orderId, String operator);
//
//    /**
//     * 唤醒历史流程实例
//     *
//     * @param orderId 流程实例id
//     * @return 活动实例对象
//     */
//    Order resume(String orderId);
//
//    /**
//     * 更新流程实例
//     *
//     * @param order 流程实例对象
//     */
//    void updateOrder(Order order);
//
//    /**
//     * 更新抄送记录为已阅
//     *
//     * @param orderId  流程实例id
//     * @param actorIds 参与者id
//     */
//    void updateCCStatus(String orderId, String... actorIds);
//
//    /**
//     * 删除抄送记录
//     *
//     * @param orderId 流程实例id
//     * @param actorId 参与者id
//     */
//    void deleteCCOrder(String orderId, String actorId);
}
