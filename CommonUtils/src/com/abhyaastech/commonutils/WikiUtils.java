package com.abhyaastech.commonutils;

public class WikiUtils {
	
	public static String getWikipediaURL(String text) {

		int idx = text.indexOf("\"http://en.wikipedia.org");
		if (idx == -1) {
			return null;
		}
		int idx_end = text.indexOf('"', idx + 1);

		if (idx_end == -1) {
			return null;
		}

		int idx_hash = text.indexOf('#', idx + 1);

		if (idx_hash != -1 && idx_hash < idx_end) {
			return text.substring(idx + 1, idx_hash);
		} else {
			return text.substring(idx + 1, idx_end);
		}

	}

}
