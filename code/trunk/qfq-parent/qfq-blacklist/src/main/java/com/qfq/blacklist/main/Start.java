package com.qfq.blacklist.main;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qfq.blacklist.service.BlackListService;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.,Ltd. Beijing
 * @bulid: 2015年8月3日 上午8:58:51
 * @author Chang Yuxin
 * @version 1.0
 */
public class Start {
	private static final Logger logger = LoggerFactory.getLogger(Start.class);
	static AbstractApplicationContext context;
	public static final long LONG_MAX = 9223372036854775807L;

	/**
	 * 系统启动
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {

		// 启动spring容器
		context = new ClassPathXmlApplicationContext(
				"applicationContext-common.xml", 
				"applicationContext-db.xml"
			);
		BlackListService blackListService = (BlackListService) context.getBean("blackListService");
		try {
			blackListService.updateBlackList();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		logger.info("Start successfully!.....");
	}

}
