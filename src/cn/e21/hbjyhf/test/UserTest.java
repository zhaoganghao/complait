package cn.e21.hbjyhf.test;

import java.util.List;

import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import cn.e21.hbjyhf.model.Page;
import cn.e21.hbjyhf.model.User;
import cn.e21.hbjyhf.service.UserService;
import cn.e21.hbjyhf.service.impl.UserServiceImpl;

public class UserTest {

	@Test
	public void test() {
		UserService s=new	UserServiceImpl();
	}
	@Test
	public void test2() {
	new AnnotationConfiguration().configure();
}
}