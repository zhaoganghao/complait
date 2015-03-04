package cn.e21.hbjyhf.test;

import java.util.List;

import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import cn.e21.hbjyhf.model.Diploma;
import cn.e21.hbjyhf.service.DiplomaService;
import cn.e21.hbjyhf.service.impl.DiplomaServiceImpl;

public class DiplomaTest {

	@Test
	public void test() {
		DiplomaService s=new	DiplomaServiceImpl();
		List<Diploma> es=s.getAllDiploma();
		System.out.println(es.size());
	}
	@Test
	public void test2() {
	new AnnotationConfiguration().configure();
}
}