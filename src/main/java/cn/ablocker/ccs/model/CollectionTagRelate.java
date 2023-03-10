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
public class CollectionTagRelate {
	@EmbeddedId
	private CollectionTagRelateId id;
	
	@Column(insertable = false, updatable = false)
	private String tag;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "collectionId",
		nullable = false,
		referencedColumnName = "id",
		foreignKey = @ForeignKey(name = "CT_FK"),
		insertable = false,
		updatable = false
	)
	private Collection collection;
	
	@Override
	public String toString() {
		return this.tag;
	}
}
