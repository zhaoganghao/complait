package cn.e21.hbjyhf.service;

import cn.e21.hbjyhf.model.DirectReply;

public interface DirectReplyService {
	public void add(DirectReply directReply);
	public DirectReply find(int id);
	public DirectReply getDirectReplyById(int aid);
}
