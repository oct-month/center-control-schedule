package cn.ablocker.ccs.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ablocker.ccs.request.RegisterRequest;

@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {
	@Autowired
	private Logger controllerLogger;
	@Autowired
	private Random controllerRandom;
	
	@PostMapping(value = "/register", produces = "application/json")
	public Map<String, String> register(@RequestBody RegisterRequest body) {
		controllerLogger.error(body);
		// TODO 注册逻辑
		Map<String, String> res = new HashMap<>();
		String deviceIdPre = body.toString() + new Date().toString() + controllerRandom.nextInt();
		String deviceId = DigestUtils.sha256Hex(deviceIdPre);
		res.put("id", deviceId);
		return res;
	}
}
