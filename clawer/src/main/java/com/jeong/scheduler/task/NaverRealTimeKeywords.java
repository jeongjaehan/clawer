package com.jeong.scheduler.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class NaverRealTimeKeywords extends QuartzJobBean {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		String pageUrl = "http://naver.com/";
		try {
			Document doc = Jsoup.connect(pageUrl).get();
			String selector = "#realrank li a"; // css selector

			Elements rcw = doc.select(selector);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			long nowmills = System.currentTimeMillis();
			String now = sdf.format(new Date(nowmills));
			log.info("실검색어 가져온 시간 : {}" , now);

			for (Element el : rcw) {
				String id = el.parent().attr("id");
				String no = el.parent().attr("value");
				String newORup = el.parent().attr("class");
				String title = el.attr("title");
				String link = el.attr("href");

				if (!id.equals("lastrank")) {
					log.debug("{},{},{},{}",new Object[]{no,title,newORup,link});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
