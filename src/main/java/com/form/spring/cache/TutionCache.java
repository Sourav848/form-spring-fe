package com.form.spring.cache;



import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.form.spring.common.api.ApiMeta;
import com.form.spring.model.User;
import com.form.spring.response.TokenResponse;
import com.form.spring.utils.Tokenizer;
/*import com.form.spring.service.LoginService;
*/import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class TutionCache {
	
	
	
	
	
	/*
	 * private static LoadingCache<ApiMeta, User> userCache =
	 * CacheBuilder.newBuilder().maximumSize(20000).expireAfterWrite(30,
	 * TimeUnit.SECONDS) .build(new CacheLoader<ApiMeta, User>() {
	 * 
	 * @Override public User load(ApiMeta apiMeta) throws Exception { User user =
	 * null; TokenResponse tokenResponse = LoginService.validateToken(apiMeta); if
	 * (tokenResponse != null) if (tokenResponse.isS()) user =
	 * tokenResponse.getUser(); return user; } });
	 */

	
	private static LoadingCache<String, String> playerLoginToken = CacheBuilder.newBuilder().maximumSize(20000).expireAfterWrite(30, TimeUnit.SECONDS)
			.build(new CacheLoader<String, String>() {
				@Override
				public String load(String ip) {
					return Tokenizer.generateUniqueToken();
				}
			});

	public static String assignAndGetToken(String ip) {
		String token = null;
		try {
			token = playerLoginToken.get(ip);
		} catch (Exception e) {
		}
		return token;
	}

	
	/*
	 * public static User getUser(String token, String ip) { User player = null;
	 * ApiMeta apiMeta = new ApiMeta(token, null, ip); try { player =
	 * userCache.get(apiMeta); } catch (Exception e) { } return player; }
	 */
	

}


