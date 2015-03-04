package cn.e21.hbjyhf.service;

import java.util.List;

import cn.e21.hbjyhf.model.Copy;
import cn.e21.hbjyhf.model.Information;
import cn.e21.hbjyhf.model.Page;

public interface CopyService {

	public void add(Copy copy);
	public void update(Copy copy);
	public void del(Copy copy);
	public Copy getCopyById(int id);
	public List<Copy> getCopys();
	
}
