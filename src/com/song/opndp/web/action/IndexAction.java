package com.song.opndp.web.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

public class IndexAction extends BasicAction {

	public static Logger logger = Logger.getLogger(IndexAction.class);

	/**
	 * 到首页
	 * 
	 * @return
	 */
	public String toIndexPage() {
		return Action.SUCCESS;
	}

	/**
	 * 到不存在的页面
	 * 
	 * @return
	 */
	public String toNotexist() {
		return Action.SUCCESS;
	}

}
