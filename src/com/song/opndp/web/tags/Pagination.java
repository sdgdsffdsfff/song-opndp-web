package com.song.opndp.web.tags;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class Pagination {

	/** 当前页码 */
	public static final String CURRPAGE = "page";

	/** 每页显示数 */
	public static final String PAGESIZE = "pageSize";

	/**
	 * 根据输入的strURL向它加入?或&
	 * 
	 * @param strURL
	 * @return
	 */
	private static String pasteURL(String strURL) {
		if (strURL == null || strURL.equals("")) {
			return strURL;
		}

		if (strURL.indexOf("?") < 0) {
			return strURL + "?";
		} else if (strURL.lastIndexOf("?") + 1 == strURL.length()) {
			return strURL;
		} else if (strURL.lastIndexOf("&") + 1 != strURL.length()) {
			return strURL + "&";
		}

		return strURL;
	}

	public static String getRequestParams() {
		return null;
	}

	/**
	 * 获取完整的URL
	 * 
	 * @param request
	 * @param URL
	 * @return
	 */
	private static String getUrl(HttpServletRequest request, String URL) {
		// 解析URL参数信息
		StringBuffer params = new StringBuffer();
		Map<?, ?> map = request.getParameterMap();
		Set<?> set = map.keySet();
		Iterator<?> it = set.iterator();
		int times = 0;
		while (it.hasNext()) {
			Object key = it.next();
			String value = request.getParameter(key.toString());
			if (!key.toString().equalsIgnoreCase(Pagination.CURRPAGE)
					&& !key.toString().equalsIgnoreCase("method")
					&& !key.toString().equalsIgnoreCase(Pagination.PAGESIZE)) {
				if (times != 0) {
					params.append("&").append(key.toString()).append("=")
							.append(value);
				} else {
					params.append(key.toString()).append("=").append(value);
				}
				times++;
			}
		}

		// 完整的URL连接
		return pasteURL(URL) + params;
	}

	private static int total(int totalNumber, int pageSize) {
		if (pageSize == 0)
			pageSize = 10;
		// 计算页数
		int total = 0;
		if (totalNumber % pageSize == 0) {
			total = totalNumber / pageSize;
		} else {
			total = totalNumber / pageSize + 1;
		}
		return total;
	}

	private static int currentPage(int currentPage, int total) {
		// 判断currentPage
		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > total) {
			currentPage = total;
		}
		return currentPage;
	}

	/**
	 * 实现分页功能
	 * 
	 * @param request
	 * @param URL
	 *            访问路径
	 * @param totalNumber
	 *            总数
	 * @param pageSize
	 *            每页数量
	 * @param currentPage
	 *            当前页
	 * @param showTotal
	 *            是否显示总数
	 * @param showCombo
	 *            是否显示下拉框
	 * @param unit
	 *            单位
	 * @return
	 */
	public static String showPage(HttpServletRequest request, String URL,
			int totalNumber, int pageSize, int currentPage, boolean showTotal,
			boolean showCombo, String unit) {
		int n = total(totalNumber, pageSize);
		currentPage = currentPage(currentPage, n);
		URL = getUrl(request, URL);

		StringBuffer str = new StringBuffer();
		str
				.append("<div><form id='showPageForm' name='showPageForm' method='get' action='"
						+ URL + "'>");
		if (showTotal = true) {
			str.append("共 <b>" + totalNumber + "</b> " + unit + "&nbsp;&nbsp;");
		}

		// 根据输入的URL向它加入?或&
		String strUrl = pasteURL(URL);

		if (currentPage < 2) {
			str.append("首页 上一页&nbsp;");
		} else {
			str.append("<a href='" + strUrl + "page=1&pageSize=" + pageSize
					+ "'>首页</a>&nbsp;");
			str.append("<a href='" + strUrl + "page=" + (currentPage - 1)
					+ "&pageSize=" + pageSize + "'>上一页</a>&nbsp;");
		}

		if (n - currentPage < 1) {
			str.append("下一页 尾页");
		} else {
			str.append("<a href='" + strUrl + "page=" + (currentPage + 1)
					+ "&pageSize=" + pageSize + "'>下一页</a>&nbsp;");
			str.append("<a href='" + strUrl + "page=" + n + "&pageSize="
					+ pageSize + "'>尾页</a>");
		}

		str.append("&nbsp;页次：<strong><font color=red>" + currentPage
				+ "</font>/" + n + "</strong>页 ");

		str.append("&nbsp;<b>" + pageSize + "</b>" + unit + "/页");

		if (showCombo == true) {
			str
					.append("&nbsp;转到：<select name='page' size='1' onchange='javascript:submit()' ID='page'>");
			for (int i = 1; i <= n; i++) {
				str.append("<option value='" + i + "'");
				if (currentPage == i) {
					str.append("selected");
				}
				str.append(">第" + i + "页</option>");
			}
			str.append("</select>");
		}
		str.append("</form></div>");
		return str.toString();
	}

	public static String showPage2(HttpServletRequest request, String URL,
			int totalNumber, int pageSize, int currentPage) {
		int n = total(totalNumber, pageSize);
		currentPage = currentPage(currentPage, n);
		URL = getUrl(request, URL);
		// 根据输入的URL向它加入?或&
		String strUrl = pasteURL(URL);

		// 组装HTML
		StringBuffer str = new StringBuffer();
		str.append("<form name='showPageForm' method='get'>");
		str.append("<div class='pagination'>");

		if (currentPage <= 1) {
			str.append("<span class='current prev'>上一页</span>");
		} else {
			str.append("<a href='" + strUrl + "page=" + (currentPage - 1)
					+ "&pageSize=" + pageSize + "' class='prev'>上一页</a>&nbsp;");
		}

		int begin = currentPage - 4;
		int end = currentPage + 4;
		if (begin < 1) {
			begin = 1;
		}
		if (end > n) {
			end = n;
		}
		for (; begin <= end; begin++) {
			if (currentPage != begin) {
				str.append("<a href='" + strUrl + "page=" + begin
						+ "&pageSize=" + pageSize + "'>" + begin + "</a>");
			} else {
				str.append("<span class='current'>" + begin + "</span>");
			}
		}

		if (n - currentPage <= 0) {
			str.append("<span class='current next'>下一页</span>");
		} else {
			str.append("<a href='" + strUrl + "page=" + (currentPage + 1)
					+ "&pageSize=" + pageSize + "' class='next'>下一页</a>");
		}
		str.append("</div></form>");

		return str.toString();
	}

	/**
	 * 不明总页数的分页
	 * 
	 * @return
	 */
	public static String showPageNoTotal(HttpServletRequest request,
			String URL, int pageSize, int currentPage) {
		// 判断currentPage
		if (currentPage < 1) {
			currentPage = 1;
		}
		URL = getUrl(request, URL);
		// 根据输入的URL向它加入?或&
		String strUrl = pasteURL(URL);

		// 组装HTML
		StringBuffer str = new StringBuffer();
		str.append("<div class='pagination'>");
		str.append("<label>当前第" + currentPage + "页</lable> ");

		if (currentPage <= 1) {
			str.append("<span class='current prev'>上一页</span>");
		} else {
			str.append("<a href='" + strUrl + "page=" + (currentPage - 1)
					+ "&pageSize=" + pageSize + "' class='prev'>上一页</a>&nbsp;");
		}

		str.append("<a href='" + strUrl + "page=" + (currentPage + 1)
				+ "&pageSize=" + pageSize + "' class='next'>下一页</a>");
		str.append("</div>");

		return str.toString();
	}

	/**
	 * 无刷新分页
	 * 
	 * @return
	 */
	public static String showPageAjax(HttpServletRequest request, String URL,
			int totalNumber, int pageSize, int currentPage, String divId) {
		int n = total(totalNumber, pageSize);
		currentPage = currentPage(currentPage, n);
		URL = getUrl(request, URL);
		// 根据输入的URL向它加入?或&
		String strUrl = pasteURL(URL);

		// 组装HTML
		StringBuffer str = new StringBuffer();
		str.append("<form name='showPageForm' method='get'/>");
		str.append("<script type='text/javascript'>var ShowPage = {};");
		str.append("ShowPage.gotoURL = function(currentPage);");
		str.append("{$('#" + divId + "').load('" + strUrl + "pageSize="
				+ pageSize + "&page='+currentPage);}</script>");
		str.append("<div class='pagination'>");

		if (currentPage <= 1) {
			str.append("<span class='current prev'>上一页</span>");
		} else {
			str.append("<a href='javascript:ShowPage.gotoURL("
					+ (currentPage - 1) + ");'class='prev'>上一页</a>&nbsp;");
		}

		int begin = currentPage - 4;
		int end = currentPage + 4;
		if (begin < 1) {
			begin = 1;
		}
		if (end > n) {
			end = n;
		}
		for (; begin <= end; begin++) {
			if (currentPage != begin) {
				str.append("<a href='javascript:ShowPage.gotoURL(" + (begin)
						+ ");'>" + begin + "</a>");
			} else {
				str.append("<span class='current'>" + begin + "</span>");
			}
		}

		if (n - currentPage <= 0) {
			str.append("<span class='current next'>下一页</span>");
		} else {
			str.append("<a href='javascript:ShowPage.gotoURL("
					+ (currentPage + 1) + ");' class='next'>下一页</a>");
		}
		str.append("</div></form>");
		return str.toString();
	}

}
