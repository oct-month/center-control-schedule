package cn.ablocker.ccs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ablocker.ccs.model.Collection;

public interface CollectionDao extends JpaRepository<Collection, String> {

}
