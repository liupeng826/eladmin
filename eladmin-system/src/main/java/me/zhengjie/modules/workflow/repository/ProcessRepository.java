package me.zhengjie.modules.workflow.repository;

import me.zhengjie.modules.workflow.Page;
import me.zhengjie.modules.workflow.QueryFilter;
import me.zhengjie.modules.workflow.domain.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static me.zhengjie.modules.workflow.repository.AbstractDBAccess.QUERY_VERSION;

/**
 * @author Peng
 * @date 2020-03-25
 */
@SuppressWarnings("all")
public interface ProcessRepository extends JpaRepository<Process, String>, JpaSpecificationExecutor<Process> {

    /**
     * 根据流程名称查询最近的版本号
     *
     * @param name
     * @return Integer 流程定义版本号
     */
    @Query(value = QUERY_VERSION + " where name = ?1", nativeQuery = true)
    Integer getLatestProcessVersion(String name);
//
//    /**
//     * 保存流程定义对象
//     *
//     * @param process 流程定义对象
//     */
//    void saveProcess(Process process);
//
//    /**
//     * 更新流程定义类别
//     *
//     * @param type 类别
//     * @since 1.5
//     */
//    void updateProcessType(String id, String type);

    /**
     * 根据流程定义id查询流程定义对象
     *
     * @param id 流程定义id
     * @return Process 流程定义对象
     */
    Process getProcessById(String id);

//    /**
//     * 更新流程定义对象
//     *
//     * @param process 流程定义对象
//     */
//    void updateProcess(Process entity);
//
//    /**
//     * 根据查询的参数，分页对象，返回分页后的查询结果
//     *
//     * @param page   分页对象
//     * @param filter 查询过滤器
//     * @return List<Process> 流程定义集合
//     */
//    List<Process> getProcesss(Page<Process> page, QueryFilter filter);
}
