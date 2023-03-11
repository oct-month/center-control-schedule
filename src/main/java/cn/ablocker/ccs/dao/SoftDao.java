package cn.ablocker.ccs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ablocker.ccs.model.Soft;

public interface SoftDao extends JpaRepository<Soft, String> {
	public Optional<Soft> findTop1BySceneOrderByVersionCodeDesc(String scene);
}
