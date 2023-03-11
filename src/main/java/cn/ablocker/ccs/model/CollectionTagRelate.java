package cn.ablocker.ccs.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import cn.ablocker.ccs.serializer.CollectionTagDeserializer;
import cn.ablocker.ccs.serializer.CollectionTagSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@JsonSerialize(using = CollectionTagSerializer.class)
@JsonDeserialize(using = CollectionTagDeserializer.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
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
