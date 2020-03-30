package test.query;

import org.junit.Test;
import me.zhengjie.access.Page;
import me.zhengjie.access.QueryFilter;
import me.zhengjie.entity.HistoryOrder;
import me.zhengjie.test.TestSnakerBase;

/**
 * 流程实例查询测试
 * @author yuqs
 * @since 1.0
 */
public class TestQueryCCOrder extends TestSnakerBase {
	@Test
	public void test() {
		Page<HistoryOrder> page = new Page<HistoryOrder>();
		System.out.println(engine.query().getCCWorks(page, new QueryFilter().setState(1)));
	}
}
