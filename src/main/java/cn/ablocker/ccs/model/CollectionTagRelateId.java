package cn.ablocker.ccs.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class CollectionTagRelateId implements Serializable {
	private static final long serialVersionUID = -4296636291271045739L;
	
	private String collectionId;
	
	private String tag;
	
	public boolean equals(Object o) {
		if (o instanceof CollectionTagRelateId) {
			CollectionTagRelateId other = (CollectionTagRelateId) o;
			return (this.collectionId == other.getCollectionId()) && (this.tag == other.getTag());
		}
		return false;
	}
	
	public int hashCode() {
		int result = 16;
		result = 27 * result + (this.collectionId == null ? 0 : this.collectionId.hashCode());
		result = 27 * result + (this.tag == null ? 0 : this.tag.hashCode());
		return result;
	}
}
