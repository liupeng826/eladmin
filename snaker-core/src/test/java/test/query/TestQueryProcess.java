package test.query;

import org.junit.Test;
import me.zhengjie.access.Page;
import me.zhengjie.access.QueryFilter;
import me.zhengjie.entity.Process;
import me.zhengjie.test.TestSnakerBase;

/**
 * 流程定义查询测试
 * @author yuqs
 * @since 1.0
 */
public class TestQueryProcess extends TestSnakerBase {
	@Test
	public void test() {
		System.out.println(engine.process().getProcesss(null));
		System.out.println(engine.process().getProcesss(new Page<Process>(),
				new QueryFilter().setName("subprocess1")));
		System.out.println(engine.process().getProcessByVersion("subprocess1", 0));
		System.out.println(engine.process().getProcessByName("subprocess1"));
	}
}
