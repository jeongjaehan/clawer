package com.jeong.fetcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Example program to list links from a URL.
 */
public class LinkFetcher {
	
	/**
	 * 웹사이트에서 link 가져오기 (재귀)
	 * @param queue
	 * @throws Exception
	 */
	public void fetch(LinkQueue queue) throws Exception{
		String url = queue.deQueue();

		Document doc = Jsoup.connect(url).get();
		Elements href = doc.select("a[href]");

		for (Element el : href) {
			String link= el.attr("abs:href").trim();
			
			// 링크주소가 유효할경우 queue에 링크 저장
			if(varifyLink(link)) {
				queue.enQueue(link);
			}
			
		}
		
		if(queue.getSize() >= 500)
			return;
		else
			fetch(queue); // 재귀
	}
	
	/**
	 * 링크 유효성 검사
	 * @param link
	 * @return
	 */
	public boolean varifyLink(String link){
		boolean varified = true;

		// 길이 체크 
		if(link.getBytes().length==0)
			varified = false;
		
		// 확장자 체크 (exe)
		if(link.lastIndexOf(".exe") != -1)
			varified = false;
		
		return varified;
	}
	
	public static void main(String[] args) throws Exception {
		LinkFetcher lf = new LinkFetcher();
		LinkQueue queue = new LinkQueue();
		queue.enQueue("http://naver.com"); // 최초 탐색할 url 세팅 
		lf.fetch(queue);
//		lf.goFetch();

	}
}
