package com.example.mvc.service;

import java.io.InputStream;

/**
 * 日志服务类。
 * 
 * @author qaohao
 */
public interface LogService {
	/**
	 * Combined Log格式解析
	 * 
	 * @param is
	 */
	void parse(InputStream is);
}