package cn.ablocker.ccs.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collection {
	@Id
	private String id;
	
	private String name;
	
	private String cover;
	
	@OneToMany(mappedBy = "collection", fetch = FetchType.LAZY)
	private List<CollectionTagRelate> tags;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "ResourceCollectionRelate",
		joinColumns = @JoinColumn(
			name = "collectionId",
			nullable = false,
			referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "RCR_FK_2")
		),
		inverseJoinColumns = @JoinColumn(
			name = "resourceId",
			nullable = false,
			referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "RCR_FK_1")
		)
	)
	private List<Resource> resources;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "collections", fetch = FetchType.LAZY)
	private List<User> allowUsers;
}
