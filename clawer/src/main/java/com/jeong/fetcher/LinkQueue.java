package com.jeong.fetcher;

import java.util.LinkedHashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkQueue {

	protected LinkedHashSet<String> links;
	private int cur_idx = 0;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public LinkQueue() {
		links = new LinkedHashSet<String>();
	}

	public void enQueue(String s) {
		// 중복 방지
		if (!links.contains(s)) {
			logger.debug("{} - 추가 ({})", new Object[] { s, links.size() });
			links.add(s);
		}
	}

	public String deQueue() {
		Object[] arr = links.toArray();
		String link = arr[cur_idx++].toString();
		// System.out.println(cur_idx+","+link+","+links.size());
		return link;
	}

	public int getSize() {
		return links.size();
	}

}
