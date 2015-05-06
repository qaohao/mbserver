package com.example.mvc.service;

import javax.servlet.http.HttpServletRequest;

public interface AppService {
	/**
	 * 获取魔盒应用列表。
	 * 
	 * @param mac
	 *            物理地址
	 * @param request
	 *            可选参数，http请求对象
	 * @return 应用列表。
	 */
	String getAppList(String mac, HttpServletRequest request);
}