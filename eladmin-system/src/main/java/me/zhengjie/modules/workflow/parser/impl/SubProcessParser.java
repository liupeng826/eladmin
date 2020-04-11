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

import me.zhengjie.modules.workflow.parser.AbstractNodeParser;
import org.apache.commons.lang3.math.NumberUtils;
import me.zhengjie.modules.workflow.helper.ConfigHelper;
import me.zhengjie.modules.workflow.helper.StringHelper;
import me.zhengjie.modules.workflow.model.NodeModel;
import me.zhengjie.modules.workflow.model.SubProcessModel;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;

/**
 * 子流程节点解析类
 *
 * @author yuqs
 * @since 1.0
 */
@Component
public class SubProcessParser extends AbstractNodeParser {
    /**
     * 产生SubProcessModel模型对象
     */
    @Override
    protected NodeModel newModel() {
        return new SubProcessModel();
    }

    /**
     * 解析decisition节点的特有属性expr
     */
    @Override
    protected void parseNode(NodeModel node, Element element) {
        SubProcessModel model = (SubProcessModel) node;
        model.setProcessName(element.getAttribute(ATTR_PROCESSNAME));
        String version = element.getAttribute(ATTR_VERSION);
        int ver = 0;
        if (NumberUtils.isNumber(version)) {
            ver = Integer.parseInt(version);
        }
        model.setVersion(ver);
        String form = element.getAttribute(ATTR_FORM);
        if (StringHelper.isNotEmpty(form)) {
            model.setForm(form);
        } else {
            model.setForm(ConfigHelper.getProperty("subprocessurl"));
        }
    }
}
