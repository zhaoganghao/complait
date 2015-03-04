package cn.e21.hbjyhf.service;

import java.util.List;

import cn.e21.hbjyhf.model.Diploma;

public interface DiplomaService {
	public List<Diploma> getAllDiploma();
	public Diploma getDiplomById(int id);
	public void add(Diploma category);
	public void update(Diploma category);
	public void del(Diploma category);
}
