package cn.ablocker.ccs.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ResourceTagRelateId implements Serializable {
	private static final long serialVersionUID = -7220893635983531337L;
	private String resourceId;
	private String tag;
}
