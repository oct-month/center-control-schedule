package cn.ablocker.ccs.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date uptime;
	
	private String file;
	
	@OneToMany(mappedBy = "resource", fetch = FetchType.LAZY)
	private List<ResourceTagRelate> tags = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "resources", fetch = FetchType.LAZY)
	private List<Collection> collections = new ArrayList<>();;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "resources", fetch = FetchType.LAZY)
	private List<Theme> themes = new ArrayList<>();;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "whiteResources", fetch = FetchType.LAZY)
	private List<User> allowUsers = new ArrayList<>();;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "blackResources", fetch = FetchType.LAZY)
	private List<User> denyUsers = new ArrayList<>();;
}
