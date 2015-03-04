<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<div class="content ">
	<div class="header">
		<h1 class="page-title">湖北省教育厅投诉举报系统使用说明</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span8">
						<div class="hero-unit" style="margin-top: 30px;">
							<h2>欢迎使用!</h2>
							<p>本系统供省教育厅行评办进行投诉信息管理，系统功能包括管理投诉信息数据库、另外，系统提供了方便的投诉统计功能，供领导进行的评估决策.</p>
							<p>
								<a
									href="${pageContext.request.contextPath}/Servlet/InformationAction?method=addInput"
									class="btn btn-primary btn-large">开始编辑投诉</a>
							</p>
						</div>
					</div>
					<div class="span4">
						<div class="faq-content">
							<h2>系统功能目录</h2>
							<ol>
								<li><a href="#q1">编辑投诉</a>
								</li>
								<li><a>查看投诉文件</a>
									<ul>
										<li><a href="#q21">已回复投诉</a>
										</li>
										<li><a href="#q22">未回复投诉</a>
										</li>
										<li><a href="#q23">逾期回复投诉</a>
										</li>
									</ul>
								</li>
								<li><a>查看报表</a>
									<ul>
										<li><a>某地区各月图表</a>
											<ul>
												<li><a href="#q311">已回复投诉</a>
												</li>
												<li><a href="#q312">未回复投诉</a>
												</li>
												<li><a href="#q313">逾期回复投诉</a>
												</li>
											</ul>
										</li>
										<li><a href="#q32">各文凭比较图表</a>
										</li>
										<li><a href="#q33">各地区比较图表</a>
										</li>
										<li><a href="#q34">各来源比较图表</a>
										</li>
										<li><a href="#q35">投诉类别比较图表</a>
										</li>
									</ul></li>
								<li><a>用户管理</a>
									<ul>
										<li><a href="#q41">用户增加</a>
										</li>
										<li><a href="#q42">用户删除</a>
										</li>
										<li><a href="#q43">用户信息更新</a>
										</li>
									</ul>
								</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="/common/foot.jsp"%>