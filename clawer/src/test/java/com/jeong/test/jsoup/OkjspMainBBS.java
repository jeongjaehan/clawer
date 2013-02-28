package com.jeong.test.jsoup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author jeong
 * @since 2013.02.25
 * @see okjsp 최근 게시물.. 어디에 쓰지?
 */
public class OkjspMainBBS {

	public static void main(String[] args) throws Exception {

		HashMap map = new HashMap();
		ArrayList<String> resultNumbers = new ArrayList<String>();

		String pageUrl="http://okjsp.pe.kr/bbs?act=FIRST_MAIN";


		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long nowmills = System.currentTimeMillis();
		String now = sdf.format(new Date(nowmills));
		System.out.println("수행시간 : "+now);

		Document doc = Jsoup.connect(pageUrl ).get();

		Elements els= doc.select("td[class=subject]"); 	// 당첨번호
//		System.out.println(els);
		for (Element el : els) {
			System.out.println(el.firstElementSibling());
//			resultNumbers.add(el.attr("alt"));
		}
		
		map.put("resultNumbers", resultNumbers);
		
//		System.out.println(map);

	}
	
}
