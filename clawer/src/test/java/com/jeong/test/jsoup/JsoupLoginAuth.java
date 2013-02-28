package com.jeong.test.jsoup;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupLoginAuth {
	public static void main(String[] args) throws Exception{
		try {
			Connection.Response res = Jsoup.connect("https://www.okjsp.pe.kr/jsp/member/login.jsp?returnPath=https%3A%2F%2Fwww.okjsp.pe.kr%2Fjsp%2Fmember%2Finfo.jsp")
//					.data("id", "kakaruto", "password", "48621379")
//					.method(Method.GET)
					.execute();
//			System.out.println(res.cookie("SESSIONID"));
			

			Map<String, String> cookies = res.cookies();
			System.out.println(cookies);
			
//			System.out.println(res.body());

/*			Document doc2 = Jsoup.connect("https://www.okjsp.pe.kr/jsp/member/info.jsp")
					.cookies(cookies)
					.get();*/

//			System.out.println(doc2);
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
