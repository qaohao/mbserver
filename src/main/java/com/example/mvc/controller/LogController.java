package com.example.mvc.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.example.mvc.service.LogService;

/**
 * 魔盒日志收集模块
 * 
 * @author qaohao
 */
@Controller
public class LogController {
	public static final String OK = "ok";
	public static final String FAIL = "fail";
	
	private static final  Logger logger = LoggerFactory
            .getLogger(LogController.class);
	
	@Autowired
	private LogService logService;
	
	/**
	 * 收集日志
	 * 
	 * @return 状态
	 * @throws IOException 
	 */
	@RequestMapping("{mac}/log-collection")
	public @ResponseBody String collect(@PathVariable String mac,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		// 判断 request 是否有文件上传,即多部分请求
		if (!multipartResolver.isMultipart(request)) {
			logger.warn("请求中没有上传文件。");
			return FAIL;
		}

		// 转换成多部分request
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		// 获取所有上传文件
		Iterator<String> iter = multiRequest.getFileNames();
		// 业务上只有一个文件上传
		if (iter.hasNext()) {
			// 取得上传文件
			MultipartFile file = multiRequest.getFile(iter.next());
			logger.info("上传文件：".concat(file.getOriginalFilename()).concat(
					", 文件大小：" + file.getSize()));

			GZIPInputStream gis = new GZIPInputStream(file.getInputStream());
			logService.parse(gis);
			IOUtils.closeQuietly(gis);
		}

		return OK;
	}
}
