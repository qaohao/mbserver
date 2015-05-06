package com.example.mvc.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import com.example.mvc.service.AppService;

@Service
public class MockAppServiceImpl implements AppService {

	@Override
	public String getAppList(String mac, HttpServletRequest request) {
		
		final String appAddr = request.getRequestURL().toString()
				.replaceAll(request.getRequestURI().toString(), "")
				.concat(request.getContextPath())
				.concat("/public/fake/d2-87-1a-34-34-23/");

		return new StringBuilder()
				.append(appAddr).append("android/jingdongHD_10.apk")
				.append(IOUtils.LINE_SEPARATOR)
				.append(appAddr).append("android/suning_7857.apk")
				.append(IOUtils.LINE_SEPARATOR)
				.append(appAddr).append("CHECKSUM")
				.append(IOUtils.LINE_SEPARATOR)
				.append(appAddr).append("DATA.json")
				.append(IOUtils.LINE_SEPARATOR)
				.append(appAddr).append("DEVICE.json").toString();
	}

}
