/*
 * package com.form.spring.interceptor;
 * 
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.web.servlet.HandlerInterceptor; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * import com.form.spring.common.Config; import
 * com.form.spring.utils.TutionUtils;
 * 
 * 
 * 
 * public class SessionInterceptor implements HandlerInterceptor {
 * 
 * // private static final Logger logger = //
 * LoggerFactory.getLogger(SessionInterceptor.class);
 * 
 * public boolean preHandle(HttpServletRequest request, HttpServletResponse
 * response, Object arg2) throws Exception { SessionWrapper sessionWrapper =
 * TutionUtils.buildSession(request, response); String uri =
 * request.getRequestURI(); // logger.info("{} {}", uri,
 * request.getHeader("X-Real-IP")); if (uri.endsWith("/")) { if
 * (isloggedin(sessionWrapper)) { return true; } } else if
 * (!isloggedin(sessionWrapper) && !uri.endsWith("/error")) {
 * response.sendRedirect(Config.PROTOCOL + "://" + Config.DOMAIN + "/" +
 * request.getContextPath()); return false; } else if (uri.endsWith("/error")) {
 * response.sendRedirect(request.getContextPath() + "/error"); return false; }
 * return true; }
 * 
 * public static boolean isloggedin(SessionWrapper session) { if (session !=
 * null && session.getUser() != null) { return true; } return false; }
 * 
 * public void afterCompletion(HttpServletRequest arg0, HttpServletResponse
 * arg1, Object arg2, Exception arg3) throws Exception { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
 * Object arg2, ModelAndView arg3) throws Exception { // TODO Auto-generated
 * method stub
 * 
 * }
 * 
 * }
 * 
 */