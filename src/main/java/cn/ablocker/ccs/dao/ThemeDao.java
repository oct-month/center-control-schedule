package cn.ablocker.ccs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ablocker.ccs.model.Theme;

public interface ThemeDao extends JpaRepository<Theme, String> {

}
