package cn.ablocker.ccs.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CollectionTagRelateId implements Serializable {
	private static final long serialVersionUID = -4296636291271045739L;
	private String collectionId;
	private String tag;
}
