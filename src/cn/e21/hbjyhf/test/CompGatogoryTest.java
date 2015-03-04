package cn.e21.hbjyhf.test;

import java.util.List;

import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import cn.e21.hbjyhf.model.CompCategory;
import cn.e21.hbjyhf.service.CompCategoryService;
import cn.e21.hbjyhf.service.impl.CompCategoryServiceImpl;

public class CompGatogoryTest {

	@Test
	public void test() {
		CompCategoryService s=new	CompCategoryServiceImpl();
		List<CompCategory> sources=s.getAllComCategory();
		
		System.out.println(s.getComCategoryById(1));
	}
	@Test
	public void test2() {
	new AnnotationConfiguration().configure();
}
}