package com.song.opndp.web.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

public class PaginationTag extends TagSupport {

	private static final long serialVersionUID = 9111787299378957433L;

	private static Logger logger = Logger.getLogger(PaginationTag.class);

	private int totalNum;

	private int pageSize;

	private int currPage;

	private String actionName;

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public int doEndTag() {
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();

		// 显示分页
		String showPage = Pagination.showPage2(request, actionName, totalNum,
				pageSize, currPage);

		JspWriter out = pageContext.getOut();
		try {
			out.println(showPage);
		} catch (IOException e) {
			logger.error("PaginationTag.doEndTag();", e);
		}

		return EVAL_PAGE;
	}
}
