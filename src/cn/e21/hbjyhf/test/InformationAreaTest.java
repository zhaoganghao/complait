package cn.e21.hbjyhf.test;

import java.util.List;

import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import cn.e21.hbjyhf.model.Information;
import cn.e21.hbjyhf.service.InformationService;
import cn.e21.hbjyhf.service.impl.InformationServiceImpl;

public class InformationAreaTest {

	@Test
	public void test() {
		InformationService s=new	InformationServiceImpl();
	}
	@Test
	public void test2() {
	new AnnotationConfiguration().configure();
}
}