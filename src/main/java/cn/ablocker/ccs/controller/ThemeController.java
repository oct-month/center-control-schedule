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

import cn.ablocker.ccs.aspect.BasicAuth;
import cn.ablocker.ccs.dao.ThemeDao;
import cn.ablocker.ccs.model.Theme;

@RestController
@RequestMapping("/api/v1/theme")
public class ThemeController {
	@Autowired
	private ThemeDao dao;
	
	@BasicAuth
	@GetMapping(value = "/", produces = "application/json")
	public List<Theme> getResources() {
		return dao.findAll();
	}
	
	@BasicAuth
	@GetMapping(value = "/{themeId}", produces = "application/json")
	public Theme getResource(@PathVariable String themeId) {
		Optional<Theme> rs = dao.findById(themeId);
		if (rs.isPresent()) {
			return rs.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
}
