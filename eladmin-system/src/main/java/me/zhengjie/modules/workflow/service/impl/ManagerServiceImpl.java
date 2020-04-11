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

import me.zhengjie.modules.workflow.service.ManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 管理服务类
 *
 * @author yuqs
 * @since 1.4
 */
@Service
//@CacheConfig(cacheNames = "dept")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ManagerServiceImpl extends AccessService implements ManagerService {
//    @Override
//    public void saveOrUpdate(Surrogate surrogate) {
//        AssertHelper.notNull(surrogate);
//        surrogate.setState(STATE_ACTIVE);
//        if (StringHelper.isEmpty(surrogate.getId())) {
//            surrogate.setId(StringHelper.getPrimaryKey());
//            access().saveSurrogate(surrogate);
//        } else {
//            access().updateSurrogate(surrogate);
//        }
//    }
//
//    @Override
//    public void deleteSurrogate(String id) {
//        Surrogate surrogate = getSurrogate(id);
//        AssertHelper.notNull(surrogate);
//        access().deleteSurrogate(surrogate);
//    }
//
//    @Override
//    public Surrogate getSurrogate(String id) {
//        return access().getSurrogate(id);
//    }
//
//    @Override
//    public List<Surrogate> getSurrogate(QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getSurrogate(null, filter);
//    }
//
//    @Override
//    public List<Surrogate> getSurrogate(Page<Surrogate> page, QueryFilter filter) {
//        AssertHelper.notNull(filter);
//        return access().getSurrogate(page, filter);
//    }
//
//    @Override
//    public String getSurrogate(String operator, String processName) {
//        AssertHelper.notEmpty(operator);
//        QueryFilter filter = new QueryFilter().
//                setOperator(operator).
//                setOperateTime(DateHelper.getTime());
//        if (StringHelper.isNotEmpty(processName)) {
//            filter.setName(processName);
//        }
//        List<Surrogate> surrogates = getSurrogate(filter);
//        if (surrogates == null || surrogates.isEmpty()) return operator;
//        StringBuffer buffer = new StringBuffer(50);
//        for (Surrogate surrogate : surrogates) {
//            String result = getSurrogate(surrogate.getSurrogate(), processName);
//            buffer.append(result).append(",");
//        }
//        buffer.deleteCharAt(buffer.length() - 1);
//        return buffer.toString();
//    }
}
