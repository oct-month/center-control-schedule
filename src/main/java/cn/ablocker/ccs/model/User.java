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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private String name;
	
	private String role;
	
	private String passwd;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Device> devices;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "UserCollectionRelate",
		joinColumns = @JoinColumn(
			name = "userName",
			nullable = false,
			referencedColumnName = "name",
			foreignKey = @ForeignKey(name = "UCR_FK_1")
		),
		inverseJoinColumns = @JoinColumn(
			name = "collectionId",
			nullable = false,
			referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "UCR_FK_2")
		)
	)
	private List<Collection> collections;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "UserResourceWhiteRelate",
		joinColumns = @JoinColumn(
			name = "userName",
			nullable = false,
			referencedColumnName = "name",
			foreignKey = @ForeignKey(name = "URWR_FK_1")
		),
		inverseJoinColumns = @JoinColumn(
			name = "resourceId",
			nullable = false,
			referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "URWR_FK_2")
		)
	)
	private List<Resource> whiteResources;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "UserResourceBlackRelate",
		joinColumns = @JoinColumn(
			name = "userName",
			nullable = false,
			referencedColumnName = "name",
			foreignKey = @ForeignKey(name = "URBR_FK_1")
		),
		inverseJoinColumns = @JoinColumn(
			name = "resourceId",
			nullable = false,
			referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "URBR_FK_2")
		)
	)
	private List<Resource> blackResources;
}
