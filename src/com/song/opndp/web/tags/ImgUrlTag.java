package com.song.opndp.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.song.opndp.web.config.ConfigManager;

public class ImgUrlTag extends TagSupport {

	private static final long serialVersionUID = 7751058291949258484L;

	private static Logger logger = Logger.getLogger(ImgUrlTag.class);

	private String imgUrl;

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int doEndTag() {
		ConfigManager cm = ConfigManager.getInstance();
		if (!this.imgUrl.startsWith("http://")) {
			this.imgUrl = (cm.getResAccountUri() + this.imgUrl);
		}

		JspWriter out = this.pageContext.getOut();
		try {
			out.println(this.imgUrl);
		} catch (IOException e) {
			logger.error("ImgUrlTag.doEndTag();", e);
		}

		return EVAL_PAGE;
	}
}