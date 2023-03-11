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

import cn.ablocker.ccs.dao.CollectionDao;
import cn.ablocker.ccs.model.Collection;

@RestController
@RequestMapping("/api/v1/collection")
public class CollectionController {
	@Autowired
	private CollectionDao dao;
	
	@GetMapping(value = "/", produces = "application/json")
	public List<Collection> getResources() {
		return dao.findAll();
	}
	
	@GetMapping(value = "/{collectionId}", produces = "application/json")
	public Collection getResource(@PathVariable String collectionId) {
		Optional<Collection> rs = dao.findById(collectionId);
		if (rs.isPresent()) {
			return rs.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
}
