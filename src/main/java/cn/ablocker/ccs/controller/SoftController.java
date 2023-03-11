package cn.ablocker.ccs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ablocker.ccs.dao.SoftDao;
import cn.ablocker.ccs.model.Soft;

@RestController
@RequestMapping("/api/v1/soft")
public class SoftController {
	@Autowired
	private SoftDao dao;
	
	@GetMapping(value = "/", produces = "application/json")
	public List<Soft> getResources() {
		return dao.findAll();
	}
	
	@GetMapping(value = "/{softId}", produces = "application/json")
	public Soft getResource(@PathVariable String softId) {
		Optional<Soft> rs = dao.findById(softId);
		if (rs.isPresent()) {
			return rs.get();
		}
		return null;
	}
}
