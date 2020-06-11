package com.cn.ag.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cn.ag.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

	private static JwtUtil jwtUtil;

	@Autowired
	private AppConfig appConfig;

	private static final String EXP = "exp";

	private static final String PAYLOAD = "payload";

	@PostConstruct
	public void init(){
		jwtUtil = this;
		logger.info("-------------JWT 初始化成功");
	}

	// 加密，传入一个对象和有效期
	public static <T> String sign(T object, long maxAge) {
		Algorithm algorithm = Algorithm.HMAC256(jwtUtil.appConfig.getSecret());
		final Map<String, Object> map = new HashMap<>();
		map.put("alg","HS256");
		map.put("type","JWT");

		return JWT.create()
				.withHeader(map) // 设置头部信息 Header
				.withIssuer(jwtUtil.appConfig.getAppName())//设置 载荷 签名是有谁生成 例如 服务器
				.withClaim(PAYLOAD, JSON.toJSONString(object))
				.withExpiresAt(new Date(System.currentTimeMillis() + maxAge))//设置 载荷 签名过期的时间
				.sign(algorithm);
	}

	// 解密，传入一个加密后的token字符串和解密后的类型
	public static <T> T unsign(String token, Class<T> classT) {

		try {
			Algorithm algorithm = Algorithm.HMAC256(jwtUtil.appConfig.getSecret());
			JWTVerifier verifier = JWT.require(algorithm)
					.withIssuer(jwtUtil.appConfig.getAppName())
					.build();
			DecodedJWT verify = verifier.verify(token);
			String json = verify.getClaim(PAYLOAD).asString();
			return JSON.parseObject(json, classT);
		}catch (Exception e){
			logger.error(e.getMessage());
			return null;
		}

	}

}