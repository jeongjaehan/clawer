package com.jeong.clawer;

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
 * @see 로또번호 가져오기 
 */
public class LottoNumbers {

	public static void main(String[] args) throws Exception {

		HashMap map = new HashMap();
		ArrayList<String> resultNumbers = new ArrayList<String>();

		String pageUrl="http://www.645lotto.net/main.asp";


		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long nowmills = System.currentTimeMillis();
		String now = sdf.format(new Date(nowmills));
		System.out.println("수행시간 : "+now);

		Document doc = Jsoup.connect(pageUrl ).get();
		String gateDate= doc.select("#gameDate").text(); // 당첨일시
		String winCount= doc.select("#winCount").text();	// 당첨자수

		Elements els= doc.select("img[class=png24]"); 	// 당첨번호
		for (Element el : els) {
			resultNumbers.add(el.attr("alt"));
		}
		
		map.put("gateDate", gateDate);
		map.put("resultNumbers", resultNumbers);
		map.put("winCount", winCount);
		
		System.out.println(map);

	}
	
}
