package cn.ablocker.ccs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cn.ablocker.ccs.dao.ResourceDao;
import cn.ablocker.ccs.model.Resource;

@RestController
@RequestMapping("/api/v1/resource")
public class ResourceController {
	@Autowired
	private ResourceDao dao;
	
	@GetMapping(value = "/", produces = "application/json")
	public List<Resource> getResources() {
		return dao.findAll();
	}
	
	@GetMapping(value = "/{resourceId}", produces = "application/json")
	public Resource getResource(@PathVariable String resourceId) {
		Optional<Resource> rs = dao.findById(resourceId);
		if (rs.isPresent()) {
			return rs.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
}
