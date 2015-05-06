package com.example.mvc.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.mvc.controller.LogController;
import com.example.mvc.service.LogService;

@Service
public class LogServiceImpl implements LogService {
	private static final Logger logger = LoggerFactory
            .getLogger(LogController.class);
	
	@Override
	public void parse(InputStream is) {
		try {
			logger.debug(IOUtils.toString(is));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
