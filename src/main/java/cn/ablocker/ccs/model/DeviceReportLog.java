package cn.ablocker.ccs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "deviceId",
		nullable = false,
		referencedColumnName = "id",
		foreignKey = @ForeignKey(name = "DRL_FK_1")
	)
	private Device device;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "softId",
		nullable = true,
		referencedColumnName = "id",
		foreignKey = @ForeignKey(name = "DRL_FK_2")
	)
	private Soft soft;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	
	private float longitude;
	
	private float latitude;
	
	private int clientCount;
	
	private float speedCount;
}
