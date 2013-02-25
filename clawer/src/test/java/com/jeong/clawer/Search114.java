package com.jeong.clawer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Search114 {
	public static void main(String[] args) throws Exception{
		try {
			HashMap<String,String> params = new HashMap<String,String>();
			params.put("keyword", "족발");
			params.put("searchType", "3");
			params.put("dongcode", "");
			
			Connection.Response res = Jsoup.connect("http://www.114.co.kr/search/findSearchBusinessListAjax.action")
					.data(params)
					.method(Method.POST)
					.execute();

//			Map<String, String> cookies = res.cookies();
//			System.out.println(cookies);
//			System.out.println(res.parse());
			String selector = "li";
			
			System.out.println(res.parse().select(selector));
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
