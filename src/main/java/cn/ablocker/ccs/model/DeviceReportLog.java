package cn.ablocker.ccs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceReportLog {
	@Id
	private String id;
	@OneToOne(targetEntity = Device.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "deviceId", nullable = true)
	private Device device;
	@OneToOne(targetEntity = Soft.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "softId", nullable = true)
	private Soft soft;
	private Date time;
	private float longitude;
	private float latitude;
	private int clientCount;
	private float speedCount;
}
