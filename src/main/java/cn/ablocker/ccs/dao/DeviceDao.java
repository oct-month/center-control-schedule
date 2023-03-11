package cn.ablocker.ccs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ablocker.ccs.model.Device;

public interface DeviceDao extends JpaRepository<Device, String> {

}
