package com.qfq.blacklist.service.impl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qfq.blacklist.bean.Black;
import com.qfq.blacklist.dao.BlackListDao;
import com.qfq.blacklist.service.BlackListService;
import com.qfq.blacklist.util.MD5Util;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.,Ltd. Beijing
 * @bulid: 2015年8月3日 上午9:25:46
 * @author Chang Yuxin
 * @version 1.0
 */
@Service("blackListService")
public class BlackListServiceImpl implements BlackListService {

	private static final Logger logger = LoggerFactory.getLogger(BlackListServiceImpl.class);
	@Resource
	public BlackListDao blackListDao;

	@Override
	public void updateBlackList() throws NoSuchAlgorithmException {
		// 获取所有黑名单
		logger.info("Crawler black list start!.....");
		List<Black> blackList = blackListDao.getBlackList();
		logger.info("Loading black list size: " + blackList.size());

		// 转化黑名单数据
		Map<String, Black> map = convertBlackList(blackList);
		logger.info("Loading black list successfully!.....");
		while (true) {
			try {
				List<Black> list = new ArrayList<Black>();
				logger.info("Crawling http://www.p2pblack.com/");
				Connection conn = Jsoup.connect("http://www.p2pblack.com/");
				Thread.sleep(2000);
				Elements elements = conn.get().select(".index_blackname_left");
				Elements ps = elements.get(0).getElementsByTag("p");
				for (int j = 1; j < ps.size(); j++) {
					Element p = ps.get(j);
					Elements spans = p.getElementsByTag("span");
					
					String id = spans.get(1).html();
					String name = spans.get(0).html();
					String totalArrears = spans.get(2).html();
					String totalPenalty = spans.get(3).html();
					String status = spans.get(4).html();
					Elements hrefs = p.getElementsByTag("a");
					String platform = hrefs.get(1).text();

					String str = name + platform;

					if (map.containsKey(MD5Util.encodeString(str)) == false) {
						Black black = new Black();
						black.setId(id);
						black.setName(name);
						black.setPlatform(platform);
						black.setStatus(status);
						black.setTotalArrears(totalArrears);
						black.setTotalPenalty(totalPenalty);
						list.add(black);
						map.put(MD5Util.encodeString(str), black);
					}
				}
				if (list.size() > 0) {
					blackListDao.createBlackList(list);
					logger.info("Crawler black list size: " + list.size());
				}
			} catch (IOException | InterruptedException e) {
				logger.error("Crawling http://www.p2pblack.com/ error", e);
			}
		}
	}

	/**
	 * @param blackList
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private Map<String, Black> convertBlackList(List<Black> blackList) throws NoSuchAlgorithmException {
		Map<String, Black> map = new HashMap<String, Black>();
		for (Black black : blackList) {
			String str = black.getName() + black.getPlatform();
			String md5 = MD5Util.encodeString(str);
			map.put(md5, black);
		}
		return map;
	}

}
