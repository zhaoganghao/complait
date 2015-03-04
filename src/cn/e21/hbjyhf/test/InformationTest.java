package cn.e21.hbjyhf.test;

import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import cn.e21.hbjyhf.model.Information;
import cn.e21.hbjyhf.model.Page;
import cn.e21.hbjyhf.service.InformationService;
import cn.e21.hbjyhf.service.impl.InformationServiceImpl;

public class InformationTest {

	@Test
	public void test() {
	InformationService s=new InformationServiceImpl();
	Page page=s.getInformationPage("o.aid.aid=?", null, new Object[]{10}, null);
	Information information=(Information)page.getList().get(0);
	System.out.println(information.getContent());
	}
	@Test
	public void test2() {
	new AnnotationConfiguration().configure();
}
}