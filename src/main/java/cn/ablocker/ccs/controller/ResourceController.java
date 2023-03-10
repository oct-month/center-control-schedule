package cn.ablocker.ccs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ablocker.ccs.model.Resource;

@RestController
@RequestMapping("/api/v1/resource")
public class ResourceController {
	@GetMapping(value = "/", produces = "application/json")
	public List<Resource> getResources() {
		// TODO
		return null;
	}
}
