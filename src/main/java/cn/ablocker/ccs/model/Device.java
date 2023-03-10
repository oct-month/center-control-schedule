package cn.ablocker.ccs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
	@Id
	private String id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "softId",
		nullable = true,
		referencedColumnName = "id",
		foreignKey = @ForeignKey(name = "D_FK")
	)
	private Soft soft;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date uptime;
	
	private float longitude;
	
	private float latitude;
	
	private int clientCount;
	
	private float speedCount;
}
