package com.jeong.clawer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Example program to list links from a URL.
 */
public class LinkFecher {

	private String baseUrl = "http://naver.com";
	private Set<String> linkSet ;

	public LinkFecher() {
		linkSet  = new HashSet<String>();
		linkSet.add(baseUrl);
	}

	public int goFetch()throws Exception{
		
		while(linkSet.iterator().hasNext()){
			String url = linkSet.iterator().next();
			print("Fetching %s", url);

			Document doc = Jsoup.connect(url).get();
			Elements href = doc.select("a[href]");

			for (Element el : href) {
				String link= el.attr("abs:href").trim();
				
				if(!link.equals(""))
					linkSet.add(el.attr("abs:href"));
			}
			
			System.out.println("link Size : "+linkSet.size());
			
			if(linkSet.size() >= 10000)
				break;
			else
				goFetch();
		}
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
		LinkFecher lf = new LinkFecher();
		lf.goFetch();

		//		Validate.isTrue(args.length == 1, "usage: supply url to fetch");
		/*	String rootDomain= "http://naver.com";
		print("Fetching %s...", rootDomain);

		Document doc = Jsoup.connect(rootDomain).get();
		Elements links = doc.select("a[href]");

		print("\nLinks: (%d)", links.size());
		for (Element link : links) {
			print(" * a: <%s>  (%s)", link.attr("abs:href"),
					trim(link.text(), 35));
		}*/
	}

	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}
}
