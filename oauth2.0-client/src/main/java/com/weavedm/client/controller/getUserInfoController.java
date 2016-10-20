package com.weavedm.client.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.weavedream.client.module.msg.MsgHander;
import cn.weavedream.client.web.util.HttpTookit;

/**
 * <p>
 * User: scl
 * <p>
 * Date: 16-10-16
 * <p>
 * Version: 1.0
 */
@RestController
public class getUserInfoController {

	@RequestMapping("/getUserInfo")
	public MsgHander getuserInfo(HttpServletRequest request) {
		MsgHander msg = new MsgHander();
		String code = request.getParameter("code");
		Map<String, String> entity = new HashMap<String, String>();
		entity.put("code", code);
		entity.put("grant_type", "authorization_code");
		entity.put("code", code);
		entity.put("client_id", "c1ebe466-1cdc-4bd3-ab69-77c3561b9dee");
		entity.put("client_secret", "d8346ea2-6017-43ed-ad68-19c0f971738b");
		String token = HttpTookit.doPost("http://10.0.0.131:83/accessToken", entity);
		msg.setContext(token);
		return msg;
	}

	public static void main(String[] args) {
		String code = "d83cfb01435442918e30d0256d3f6b5f";
		Map<String, String> entity = new HashMap<String, String>();
		entity.put("code", code);
		entity.put("grant_type", "authorization_code");
		entity.put("code", code);
		entity.put("client_id", "c1ebe466-1cdc-4bd3-ab69-77c3561b9dee");
		entity.put("client_secret", "d8346ea2-6017-43ed-ad68-19c0f971738b");
		entity.put("redirect_uri", "http://10.0.0.131:81/getUserInfo");
		String token = HttpTookit.doPost("http://10.0.0.131:83/accessToken", entity);
		System.out.println(token);
	}

}
