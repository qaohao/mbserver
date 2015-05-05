package com.example.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 应用列表相关控制器。
 * 
 * @author qaohao
 */
@Controller
public class AppsController {
	 private static final Logger logger = LoggerFactory
	            .getLogger(AppsController.class);
	 
	 /**
	  * @return 最新文件列表。
	  */
	 @RequestMapping("/{mac}/update")
	 public @ResponseBody String update(@PathVariable String mac) {
		 // TODO
		 return "ok";
	 }
	 
}
