package com.jeong.clawer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * TEST 네이버 실시간 검색어 Jsoup lib를 이용하여 가져오기 
 * @author jeong
 *
 */
public class TestNaverRealTimeKeywords {

	String pageUrl="http://naver.com/";

	@Test
	public void sizeTest()throws Exception{
		Document doc = Jsoup.connect(pageUrl ).get();
		String selector="#realrank li a"; // css selector 

		Elements keywords = doc.select( selector );
		assertThat(keywords.size(), is(11)); // 마지막에 li가 하나 더잇음 -.-;;
	}

}
