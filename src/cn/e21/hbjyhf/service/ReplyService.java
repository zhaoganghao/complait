package cn.e21.hbjyhf.service;

import java.util.List;

import cn.e21.hbjyhf.model.Reply;

public interface ReplyService {
	public void add(Reply reply);
	public Reply find(int id);
	public Reply getReplyById(int aid);
}
