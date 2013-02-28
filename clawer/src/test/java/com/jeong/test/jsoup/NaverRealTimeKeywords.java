package com.jeong.test.jsoup;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 네이버 실시간 검색어 Jsoup lib를 이용하여 가져오기
 * exam format : 1,이하늬(up),http://search.naver.com/search.naver?where=nexearch&query=%EC%9D%B4%ED%95%98%EB%8A%AC&sm=top_lve&ie=utf8 
 * @author jeong
 *
 */
public class NaverRealTimeKeywords {

	public static void main(String[] args) throws Exception {

		String pageUrl="http://naver.com/";

		Document doc = Jsoup.connect( pageUrl ).get();
		System.out.println(doc.head());
		String selector="#realrank li a"; // css selector 

		Elements rcw = doc.select( selector );

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long nowmills = System.currentTimeMillis();
		String now = sdf.format(new Date(nowmills));
		System.out.println("실검색어 가져온 시간 : "+now);
		
		for (Element el : rcw) {
			String id = el.parent().attr("id");
			String no = el.parent().attr("value");
			String newORup = el.parent().attr("class");
			String title =el.attr("title");
			String link =el.attr("href");

			if(!id.equals("lastrank")){
				System.out.printf("%s,%s(%s),%s \n", no,title,newORup,link);
			}
		}
	}
}
