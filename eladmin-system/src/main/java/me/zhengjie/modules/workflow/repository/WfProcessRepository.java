package me.zhengjie.modules.workflow.repository;

import me.zhengjie.modules.workflow.domain.WfProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author peng
* @date 2020-03-28
*/
public interface WfProcessRepository extends JpaRepository<WfProcess, String>, JpaSpecificationExecutor<WfProcess> {
}