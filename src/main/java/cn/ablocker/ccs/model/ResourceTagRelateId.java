package cn.ablocker.ccs.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class ResourceTagRelateId implements Serializable {
	private static final long serialVersionUID = -7220893635983531337L;
	
	private String resourceId;
	
	private String tag;
	
	public boolean equals(Object o) {
		if (o instanceof ResourceTagRelateId) {
			ResourceTagRelateId other = (ResourceTagRelateId) o;
			return (this.resourceId == other.getResourceId()) && (this.tag == other.getTag());
		}
		return false;
	}
	
	public int hashCode() {
		int result = 16;
		result = 27 * result + (this.resourceId == null ? 0 : this.resourceId.hashCode());
		result = 27 * result + (this.tag == null ? 0 : this.tag.hashCode());
		return result;
	}
}
