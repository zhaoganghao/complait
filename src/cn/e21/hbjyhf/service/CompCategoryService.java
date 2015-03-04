package cn.e21.hbjyhf.service;

import java.util.List;

import cn.e21.hbjyhf.model.CompCategory;

public interface CompCategoryService {
	public List<CompCategory> getAllComCategory();
	public CompCategory getComCategoryById(int id);
	public void add(CompCategory category);
	public void del(CompCategory category);
	public void update(CompCategory category);
}
