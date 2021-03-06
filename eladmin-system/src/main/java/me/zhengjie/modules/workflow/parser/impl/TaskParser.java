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
package me.zhengjie.modules.workflow.parser.impl;

import me.zhengjie.modules.workflow.model.FieldModel;
import me.zhengjie.modules.workflow.model.NodeModel;
import me.zhengjie.modules.workflow.model.TaskModel;
import me.zhengjie.modules.workflow.parser.AbstractNodeParser;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务节点解析类
 * @author yuqs
 * @since 1.0
 */
@Component
public class TaskParser extends AbstractNodeParser {
	/**
	 * 由于任务节点需要解析form、assignee属性，这里覆盖抽象类方法实现
	 */
	@Override
    protected void parseNode(NodeModel node, Element element) {
		TaskModel task = (TaskModel)node;
		task.setForm(element.getAttribute(ATTR_FORM));
		task.setAssignee(element.getAttribute(ATTR_ASSIGNEE));
		task.setExpireTime(element.getAttribute(ATTR_EXPIRETIME));
		task.setAutoExecute(element.getAttribute(ATTR_AUTOEXECUTE));
		task.setCallback(element.getAttribute(ATTR_CALLBACK));
		task.setReminderTime(element.getAttribute(ATTR_REMINDERTIME));
		task.setReminderRepeat(element.getAttribute(ATTR_REMINDERREPEAT));
		task.setPerformType(element.getAttribute(ATTR_PERFORMTYPE));
		task.setTaskType(element.getAttribute(ATTR_TASKTYPE));
		task.setAssignmentHandler(element.getAttribute(ATTR_ASSIGNEE_HANDLER));
        NodeList fieldList = element.getElementsByTagName(ATTR_FIELD);
        List<FieldModel> fields = new ArrayList<FieldModel>();
        for(int i = 0; i < fieldList.getLength(); i++) {
            Element item = (Element)fieldList.item(i);
            FieldModel fieldModel = new FieldModel();
            fieldModel.setName(item.getAttribute(ATTR_NAME));
            fieldModel.setDisplayName(item.getAttribute(ATTR_DISPLAYNAME));
            fieldModel.setType(item.getAttribute(ATTR_TYPE));
            NodeList attrList = item.getElementsByTagName(ATTR_ATTR);
            for(int j = 0; j < attrList.getLength(); j++) {
                Node attr = attrList.item(j);
                fieldModel.addAttr(((Element) attr).getAttribute(ATTR_NAME),
                        ((Element) attr).getAttribute(ATTR_VALUE));
            }
            fields.add(fieldModel);
        }
        task.setFields(fields);
	}

	/**
	 * 产生TaskModel模型对象
	 */
	@Override
	protected NodeModel newModel() {
		return new TaskModel();
	}
}
