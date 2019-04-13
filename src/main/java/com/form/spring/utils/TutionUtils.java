package com.form.spring.utils;



import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.form.spring.cache.TutionCache;
import com.form.spring.common.Config;
import com.form.spring.common.api.ApiMeta;
import com.form.spring.constant.Constants;
import com.form.spring.interceptor.SessionWrapper;
import com.form.spring.model.User;



public class TutionUtils {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TutionUtils.class);

	public static boolean isNotEmpty(String input) {
		boolean flag = false;
		if (input != null && !input.trim().equals("")) {
			flag = true;
		}
		return flag;
	}

	public static String createEmailSecret(String str) {
		String email = "";
		int atIndex = str.indexOf('@');
		email = str.substring(0, 2);
		String temp = "";
		for (int i = 2; i < atIndex; i++)
			temp = temp + "x";
		email = email + temp + "@";
		temp = "";
		int dotIndex = str.indexOf(".", atIndex);
		for (int i = atIndex + 1; i < dotIndex; i++)
			temp = temp + "x";
		email = email + temp + str.substring(dotIndex);
		return email;
	}

	public static String createMobileSecret(String str) {
		String mobile = "";
		mobile = str.substring(0, 4);
		String temp = "";
		for (int i = 5; i < str.length(); i++)
			temp = temp + "x";
		mobile = mobile + temp;
		return mobile;
	}

	public static void readProperties(@SuppressWarnings("rawtypes") Class classLoad, String path, Logger logger)
			throws IOException {
		InputStream inputStream = classLoad.getClassLoader().getResourceAsStream(path);
		Properties p = new Properties();
		p.load(inputStream);

	}

	public static void readPropertiesGit(@SuppressWarnings("rawtypes") Class classLoad, String path, Logger logger)
			throws IOException {
		InputStream inputStream = classLoad.getClassLoader().getResourceAsStream(path);
		Properties p = new Properties();
		p.load(inputStream);
		Config.version = p.getProperty("git.commit.id.abbrev", null);
	}
	
	
	
	
	//Config.version = p.getProperty("git.commit.id.abbrev", null);

	
	public static HttpServletRequest sessionCreate(User  user, HttpServletRequest request)
			throws InterruptedException, ExecutionException, IOException {
		SessionWrapper session = new SessionWrapper();
		if (user != null)
			session.setUser(user);
		request.setAttribute("session", session);
		return request;
	}

	/*
	 * public static SessionWrapper buildSession(HttpServletRequest request,
	 * HttpServletResponse response) { String ip = getIP(request); SessionWrapper
	 * session = null; Cookie cookies[] = request.getCookies(); if (cookies != null)
	 * { String token = null; for (Cookie cookie : cookies) { if
	 * (cookie.getName().equals(Constants.TUTION_TOK)) { token = cookie.getValue();
	 * break; } } if (token != null) { User user = TutionCache.getUser(token, ip);
	 * if (user != null) { session = new SessionWrapper();
	 * session.setUserToken(token); session.setUser(user); } else { try {
	 * TutionUtils.removeCookie(request.getContextPath(), response, false); } catch
	 * (IOException e) { logger.error(e.getMessage()); } } } if (session != null)
	 * request.setAttribute("session", session); else
	 * request.removeAttribute("session"); } return session; }
	 */

	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null && Config.dev) {
			ip = "106.205.46.226";
		} else {
			String[] ipArray = ip.split(",");
			ip = ipArray[0];
		}
		logger.info(ip);
		return ip;
	}

	public static void setCookie(String token, HttpServletResponse response) {
		Cookie cookie = new Cookie(Constants.TUTION_TOK, token);
		cookie.setMaxAge(60 * 60 * 24);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public static void setFirstLoginCookie(String name, String token, HttpServletResponse response) {
		Cookie cookie = new Cookie(name, token);
		cookie.setMaxAge(60 * 60);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public static void removeCookie(String contextPath, HttpServletResponse response, boolean redirect)
			throws IOException {
		Cookie cookie = new Cookie(Constants.TUTION_TOK, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		if (redirect)
			response.sendRedirect(contextPath + "/");
	}

	public static void removeCookie(String name, String contextPath, HttpServletResponse response) throws IOException {
		Cookie cookie = new Cookie(name, "");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	

	public static String getClientIp(HttpServletRequest request) {
		String remoteAddr = null;
		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
			}
		}
		return remoteAddr;
	}

	

	public static ApiMeta createAPIMeta(SessionWrapper session, HttpServletRequest request) {
		String ip = getIP(request);
		// String ip = FeUtils.getClientIp(request);
		String userToken = null;
		String playerId = null;
		if (ip == null && Config.dev) {
			ip = "106.205.46.226";
		}
		logger.info(ip);
		if (session != null) {
			userToken = session.getUserToken();
		}
		return new ApiMeta(userToken, playerId, ip);
	}

	public static String getEmailAsUserName(String email) {
		String userName = email.substring(0, email.indexOf("@"));
		return userName;
	}
	
	public static String getEncryptedBySha256(String str) {
		String encryptedstr = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] hashInBytes = md.digest(str.getBytes(StandardCharsets.UTF_8));

			// bytes to hex
	        StringBuilder sb = new StringBuilder();
	        for (byte b : hashInBytes) {
	            sb.append(String.format("%02x", b));
	        }
	        encryptedstr = sb.toString();
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		return encryptedstr;
	}
}

