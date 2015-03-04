package cn.e21.hbjyhf.service;

import cn.e21.hbjyhf.model.CountryReply;
import cn.e21.hbjyhf.model.Reply;

public interface CountryReplyService {
	public void add(CountryReply countryReply);
	public CountryReply find(int id);
	public CountryReply getCountryReplyById(int aid);
}
