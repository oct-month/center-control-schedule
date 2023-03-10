package cn.ablocker.ccs.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceTagRelate {
	@EmbeddedId
	private ResourceTagRelateId id;
	
	@Column(insertable = false, updatable = false)
	private String tag;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "resourceId",
		nullable = false,
		referencedColumnName = "id",
		foreignKey = @ForeignKey(name = "RT_FK"),
		insertable = false,
		updatable = false
	)
	private Resource resource;
	
	@Override
	public String toString() {
		return this.tag;
	}
}
