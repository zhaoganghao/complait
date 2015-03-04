package cn.e21.hbjyhf.test;

import java.util.List;

import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import cn.e21.hbjyhf.model.Source;
import cn.e21.hbjyhf.service.SourceService;
import cn.e21.hbjyhf.service.impl.SourceServiceImpl;

public class SourceTest {

	@Test
	public void test() {
		SourceService s = new SourceServiceImpl();
		List<Source> sources = s.getAllSource();
		for (Source a : sources) {
			System.out.println(a.getName());
		}
		System.out.println(s.getSourceById(2));
	}

	@Test
	public void testa() {
		new AnnotationConfiguration().configure();
	}
}