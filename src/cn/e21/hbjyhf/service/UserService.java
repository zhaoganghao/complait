package cn.e21.hbjyhf.service;

import java.util.List;

import cn.e21.hbjyhf.model.Area;
import cn.e21.hbjyhf.model.Page;
import cn.e21.hbjyhf.model.User;

public interface UserService {
	public Page getUserPage(String pagenum,String url );
	public void addUser(User user);
	public User findUser(String username);
	public void delUser(User user);
	public void updateUser(User user);
	public List<Area> getArea();
	public User findUserByAid(int aid);
	public List<User> getAllUser();
}
