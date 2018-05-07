package by.htp.cinema.web.util;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestParamFormatter {

	private HttpRequestParamFormatter() {
	}

	public static int getInt(String param) {
		return Integer.parseInt(param);
	}

	public static String fixGoogleDriveUrl(String url) {
		if (url.contains("open?id="))
			url = url.replace("open?id=", "uc?id=");
		if (url.contains("file/d/"))
			url = url.replace("file/d/", "uc?id=");
		if (url.contains("/edit?usp=sharing"))
			url = url.replace("/edit?usp=sharing", "");
		return url;
	}

	public static boolean isPost(HttpServletRequest req) {
		return req.getMethod().toUpperCase().equals("POST");
	}
}
