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
package me.zhengjie.core;

import java.util.List;

import me.zhengjie.IManagerService;
import me.zhengjie.access.Page;
import me.zhengjie.access.QueryFilter;
import me.zhengjie.entity.Surrogate;
import me.zhengjie.helper.AssertHelper;
import me.zhengjie.helper.DateHelper;
import me.zhengjie.helper.StringHelper;

/**
 * 管理服务类
 * @author yuqs
 * @since 1.4
 */
public class ManagerService extends AccessService implements IManagerService {
	public void saveOrUpdate(Surrogate surrogate) {
		AssertHelper.notNull(surrogate);
		surrogate.setState(STATE_ACTIVE);
		if(StringHelper.isEmpty(surrogate.getId())) {
			surrogate.setId(StringHelper.getPrimaryKey());
			access().saveSurrogate(surrogate);
		} else {
			access().updateSurrogate(surrogate);
		}
	}

	public void deleteSurrogate(String id) {
		Surrogate surrogate = getSurrogate(id);
		AssertHelper.notNull(surrogate);
		access().deleteSurrogate(surrogate);
	}

	public Surrogate getSurrogate(String id) {
		return access().getSurrogate(id);
	}

	public List<Surrogate> getSurrogate(QueryFilter filter) {
		AssertHelper.notNull(filter);
		return access().getSurrogate(null, filter);
	}

	public List<Surrogate> getSurrogate(Page<Surrogate> page, QueryFilter filter) {
		AssertHelper.notNull(filter);
		return access().getSurrogate(page, filter);
	}

	public String getSurrogate(String operator, String processName) {
		AssertHelper.notEmpty(operator);
		QueryFilter filter = new QueryFilter().
				setOperator(operator).
				setOperateTime(DateHelper.getTime());
		if(StringHelper.isNotEmpty(processName)) {
			filter.setName(processName);
		}
		List<Surrogate> surrogates = getSurrogate(filter);
		if(surrogates == null || surrogates.isEmpty()) return operator;
		StringBuffer buffer = new StringBuffer(50);
		for(Surrogate surrogate : surrogates) {
			String result = getSurrogate(surrogate.getSurrogate(), processName);
			buffer.append(result).append(",");
		}
		buffer.deleteCharAt(buffer.length() - 1);
		return buffer.toString();
	}
}
