package com.example.mvc.controller;

import java.net.MalformedURLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mvc.service.AppService;

/**
 * 应用列表相关控制器。
 * 
 * @author qaohao
 */
@Controller
public class AppsController {
	private static final Logger logger = LoggerFactory
			.getLogger(AppsController.class);

	private HttpServletRequest request;
	
	@Autowired
	@Qualifier("mockAppServiceImpl")
	private AppService appService;
	
	/**
	 * @return 最新文件列表。
	 * @throws MalformedURLException
	 */
	@RequestMapping("/{mac}/update")
	public @ResponseBody String update(@PathVariable String mac) {
		String appList = appService.getAppList(mac, request);
		logger.debug(appList);
		return appList;
	}
	
	@Resource
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
