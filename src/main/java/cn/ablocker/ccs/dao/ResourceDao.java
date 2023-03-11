package cn.ablocker.ccs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ablocker.ccs.model.Resource;

public interface ResourceDao extends JpaRepository<Resource, String> {

}
