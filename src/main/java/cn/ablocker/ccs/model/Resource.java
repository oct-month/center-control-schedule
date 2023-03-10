package cn.ablocker.ccs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {
	@Id
	private String id;
	private String name;
	private String cover;
	private String kind;
	private String desc;
	private Date uptime;
	private String file;
}
