package cn.e21.hbjyhf.service;

import java.util.List;

import cn.e21.hbjyhf.model.CompCategory;
import cn.e21.hbjyhf.model.Source;

public interface SourceService {
	public List<Source> getAllSource();
	public Source getSourceById(int id);
	public void add(Source category);
	public void update(Source category);
	public void del(Source category);
}
