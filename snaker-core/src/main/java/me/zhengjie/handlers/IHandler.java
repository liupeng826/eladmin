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
package me.zhengjie.handlers;

import me.zhengjie.core.Execution;

/**
 * 流程各模型操作处理接口
 * @author yuqs
 * @since 1.0
 */
public interface IHandler {
	/**
	 * 子类需要实现的方法，来处理具体的操作
	 * @param execution 执行对象
	 */
	public void handle(Execution execution);
}