package cn.e21.hbjyhf.test;

import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.service.AreaService;
import cn.e21.hbjyhf.service.impl.AreaServiceImpl;

public class AreaTest {

	@Test
	public void test() {
		AreaService s=new	AreaServiceImpl();
		Area area=s.getAllArea();
	}
	@Test
	public void test2() {
	new AnnotationConfiguration().configure();
}
}