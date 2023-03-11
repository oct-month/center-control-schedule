package cn.ablocker.ccs.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class Theme {
	@Id
	private String id;
	
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "ResourceThemeRelate",
		joinColumns = @JoinColumn(
			name = "themeId",
			nullable = false,
			referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "RTR_FK_2")
		),
		inverseJoinColumns = @JoinColumn(
			name = "resourceId",
			nullable = false,
			referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "RTR_FK_1")
		)
	)
	private List<Resource> resources;
}
