package com.jeong.fetcher;

import java.util.LinkedHashSet;

public class LinkQueue {

	protected LinkedHashSet<String> links;
	private int cur_idx =0;

	public LinkQueue() {
		links = new LinkedHashSet<String>();
	}


	public Object enQueue(String s) {
		return links.add(s);
	}

	public String deQueue() {
		Object[] arr = links.toArray();
		String link = arr[cur_idx++].toString();
//		System.out.println(cur_idx+","+link+","+links.size());
		return link;
	}

	public int getSize() {
		return links.size();
	}

}
