package com.jeong.clawer;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class TestJsoup {
	public static void main(String[] args) throws Exception{
		try {
			Connection.Response res = Jsoup.connect("http://nid.naver.com/nidlogin.login?url=http://se.naver.com")
					.data("id", "kakaruto12", "pw", "Wogks!290")
					.method(Method.POST)
					.execute();
			System.out.println(res.cookie("SESSIONID"));

			Map<String, String> cookies = res.cookies();
			System.out.println(cookies);
			
			System.out.println(res.body());

			Document doc2 = Jsoup.connect("http://naver.com")
					.cookies(cookies)
					.get();

			System.out.println(doc2.text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
