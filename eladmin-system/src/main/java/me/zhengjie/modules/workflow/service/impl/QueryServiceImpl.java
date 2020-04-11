/* Copyright 2013-2015 www.snakerflow.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.zhengjie.modules.workflow.service.impl;

import me.zhengjie.modules.workflow.service.QueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 查询服务实现类
 *
 * @author yuqs
 * @since 1.0
 */
@Service
//@CacheConfig(cacheNames = "dept")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class QueryServiceImpl extends AccessService implements QueryService {
//    @Override
//    public Order getOrder(String orderId) {
//        return access().getOrder(orderId);
//    }
//
//    @Override
//    public Task getTask(String taskId) {
//        return access().getTask(taskId);
//    }
//
//    @Override
//    public String[] getTaskActorsByTaskId(String taskId) {
//        List<TaskActor> actors = access().getTaskActorsByTaskId(taskId);
//        if (actors == null || actors.isEmpty()) {
//            return null;
//        }
//        String[] actorIds = new String[actors.size()];
//        for (int i = 0; i < actors.size(); i++) {
//            TaskActor ta = actors.get(i);
//            actorIds[i] = ta.getActorId();
//        }
//        return actorIds;
//    }
//
//    @Override
//    public String[] getHistoryTaskActorsByTaskId(String taskId) {
//        List<HistoryTaskActor> actors = access().getHistTaskActorsByTaskId(taskId);
//        if (actors == null || actors.isEmpty()) {
//            return null;
//        }
//        String[] actorIds = new String[actors.size()];
//        for (int i = 0; i < actors.size(); i++) {
//            HistoryTaskActor ta = actors.get(i);
//            actorIds[i] = ta.getActorId();
//        }
//        return actorIds;
//    }
//
//    @Override
//    public HistoryOrder getHistOrder(String orderId) {
//        return access().getHistOrder(orderId);
//    }
//
//    @Override
//    public HistoryTask getHistTask(String taskId) {
//        return access().getHistTask(taskId);
//    }
//
//    @Override
//    public List<Task> getActiveTasks(QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getActiveTasks(null, filter);
//    }
//
//    @Override
//    public List<Task> getActiveTasks(Page<Task> page, QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getActiveTasks(page, filter);
//    }
//
//    @Override
//    public List<Order> getActiveOrders(QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getActiveOrders(null, filter);
//    }
//
//    @Override
//    public List<Order> getActiveOrders(Page<Order> page, QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getActiveOrders(page, filter);
//    }
//
//    @Override
//    public List<HistoryOrder> getHistoryOrders(QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getHistoryOrders(null, filter);
//    }
//
//    @Override
//    public List<HistoryOrder> getHistoryOrders(Page<HistoryOrder> page, QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getHistoryOrders(page, filter);
//    }
//
//    @Override
//    public List<HistoryTask> getHistoryTasks(QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getHistoryTasks(null, filter);
//    }
//
//    @Override
//    public List<HistoryTask> getHistoryTasks(Page<HistoryTask> page, QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getHistoryTasks(page, filter);
//    }
//
//    @Override
//    public List<WorkItem> getWorkItems(Page<WorkItem> page, QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getWorkItems(page, filter);
//    }
//
//    @Override
//    public List<HistoryOrder> getCCWorks(Page<HistoryOrder> page, QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getCCWorks(page, filter);
//    }
//
//    @Override
//    public List<WorkItem> getHistoryWorkItems(Page<WorkItem> page, QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getHistoryWorkItems(page, filter);
//    }
//
//    @Override
//    public <T> T nativeQueryObject(Class<T> T, String sql, Object... args) {
//        AssertHelper.notEmpty(sql);
//        AssertHelper.notNull(T);
//        return access().queryObject(T, sql, args);
//    }
//
//    @Override
//    public <T> List<T> nativeQueryList(Class<T> T, String sql, Object... args) {
//        AssertHelper.notEmpty(sql);
//        AssertHelper.notNull(T);
//        return access().queryList(T, sql, args);
//    }
//
//    @Override
//    public <T> List<T> nativeQueryList(Page<T> page, Class<T> T, String sql,
//                                       Object... args) {
//        AssertHelper.notEmpty(sql);
//        AssertHelper.notNull(T);
//        return access().queryList(page, new QueryFilter(), T, sql, args);
//    }
}
