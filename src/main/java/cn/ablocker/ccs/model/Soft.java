package cn.ablocker.ccs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Soft {
	@Id
	private String id;
	
	private String version;
	
	private int versionCode;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date uptime;
	
	private String scene;
	
	private String desc;
	
	private String file;
}
