package com.jeong.test.jsoup;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestDocumentText {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.yonhapnews.co.kr");

		Document doc = Jsoup.parse(url, 2000);
		
		System.out.println(doc.html());
	}
}
