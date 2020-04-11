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
package me.zhengjie.modules.workflow.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象数据库访问类
 * 封装SQL语句的构造
 * @author yuqs
 * @since 1.0
 */
public abstract class AbstractDBAccess {
    private static final Logger log = LoggerFactory.getLogger(AbstractDBAccess.class);
    protected static final String KEY_SQL = "SQL";
	protected static final String KEY_ARGS = "ARGS";
	protected static final String KEY_TYPE = "TYPE";
	protected static final String KEY_ENTITY = "ENTITY";

	protected static final String KEY_SU = "SU";
	protected static final String SAVE = "SAVE";
	protected static final String UPDATE = "UPDATE";

	protected static final String PROCESS_INSERT = "insert into wf_process (id,name,display_Name,type,instance_Url,state,version,create_Time,creator) values (?,?,?,?,?,?,?,?,?)";
	protected static final String PROCESS_UPDATE = "update wf_process set name=?, display_Name=?,state=?,instance_Url=?,create_Time=?,creator=? where id=? ";
	protected static final String PROCESS_UPDATE_BLOB = "update wf_process set content=? where id=?";
	protected static final String PROCESS_UPDATE_TYPE = "update wf_process set type=? where id=?";

	protected static final String ORDER_INSERT = "insert into wf_order (id,process_Id,creator,create_Time,parent_Id,parent_Node_Name,expire_Time,last_Update_Time,last_Updator,order_No,variable,version) values (?,?,?,?,?,?,?,?,?,?,?,?)";
	protected static final String ORDER_UPDATE = "update wf_order set last_Updator=?, last_Update_Time=?, variable = ?, version = version + 1 where id=? and version = ?";
	protected static final String ORDER_HISTORY_INSERT = "insert into wf_hist_order (id,process_Id,order_State,creator,create_Time,end_Time,parent_Id,expire_Time,order_No,variable) values (?,?,?,?,?,?,?,?,?,?)";
	protected static final String ORDER_HISTORY_UPDATE = "update wf_hist_order set order_State = ?, end_Time = ?, variable = ? where id = ? ";
	protected static final String ORDER_DELETE = "delete from wf_order where id = ?";

	protected static final String CCORDER_INSERT = "insert into wf_cc_order (order_Id, actor_Id, create_Time, status) values (?, ?, ?, ?)";
	protected static final String CCORDER_UPDATE = "update wf_cc_order set status = ?, finish_Time = ? where order_Id = ? and actor_Id = ?";
	protected static final String CCORDER_DELETE = "delete from wf_cc_order where order_Id = ? and actor_Id = ?";

	protected static final String TASK_INSERT = "insert into wf_task (id,order_Id,task_Name,display_Name,task_Type,perform_Type,operator,create_Time,finish_Time,expire_Time,action_Url,parent_Task_Id,variable,version) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	protected static final String TASK_UPDATE = "update wf_task set finish_Time=?, operator=?, version = version + 1 where id=? and version = ?";
	protected static final String TASK_HISTORY_INSERT = "insert into wf_hist_task (id,order_Id,task_Name,display_Name,task_Type,perform_Type,task_State,operator,create_Time,finish_Time,expire_Time,action_Url,parent_Task_Id,variable) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	protected static final String TASK_DELETE = "delete from wf_task where id = ?";

	protected static final String TASK_ACTOR_INSERT = "insert into wf_task_actor (task_Id, actor_Id) values (?, ?)";
	protected static final String TASK_ACTOR_HISTORY_INSERT = "insert into wf_hist_task_actor (task_Id, actor_Id) values (?, ?)";
	protected static final String TASK_ACTOR_DELETE = "delete from wf_task_actor where task_Id = ?";
	protected static final String TASK_ACTOR_REDUCE = "delete from wf_task_actor where task_Id = ? and actor_Id = ?";

	protected static final String QUERY_VERSION = "select max(version) from wf_process ";
	protected static final String QUERY_PROCESS = "select id,name,display_Name,type,instance_Url,state, content, version,create_Time,creator from wf_process ";
	protected static final String QUERY_ORDER = "select o.id,o.process_Id,o.creator,o.create_Time,o.parent_Id,o.parent_Node_Name,o.expire_Time,o.last_Update_Time,o.last_Updator,o.priority,o.order_No,o.variable, o.version from wf_order o ";
	protected static final String QUERY_TASK = "select id,order_Id,task_Name,display_Name,task_Type,perform_Type,operator,create_Time,finish_Time,expire_Time,action_Url,parent_Task_Id,variable, version from wf_task ";
	protected static final String QUERY_TASK_ACTOR = "select task_Id, actor_Id from wf_task_actor ";
	protected static final String QUERY_CCORDER = "select order_Id, actor_Id, create_Time, finish_Time, status from wf_cc_order ";

	protected static final String QUERY_HIST_ORDER = "select o.id,o.process_Id,o.order_State,o.priority,o.creator,o.create_Time,o.end_Time,o.parent_Id,o.expire_Time,o.order_No,o.variable from wf_hist_order o ";
	protected static final String QUERY_HIST_TASK = "select id,order_Id,task_Name,display_Name,task_Type,perform_Type,task_State,operator,create_Time,finish_Time,expire_Time,action_Url,parent_Task_Id,variable from wf_hist_task ";
	protected static final String QUERY_HIST_TASK_ACTOR = "select task_Id, actor_Id from wf_hist_task_actor ";

	/**委托代理CRUD*/
	protected static final String SURROGATE_INSERT = "insert into wf_surrogate (id, process_Name, operator, surrogate, odate, sdate, edate, state) values (?,?,?,?,?,?,?,?)";
	protected static final String SURROGATE_UPDATE = "update wf_surrogate set process_Name=?, surrogate=?, odate=?, sdate=?, edate=?, state=? where id = ?";
	protected static final String SURROGATE_DELETE = "delete from wf_surrogate where id = ?";
	protected static final String SURROGATE_QUERY = "select id, process_Name, operator, surrogate, odate, sdate, edate, state from wf_surrogate";


}
