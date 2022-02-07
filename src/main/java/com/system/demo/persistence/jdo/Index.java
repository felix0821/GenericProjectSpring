package com.system.demo.persistence.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Index {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private int pedagogicalPeriodIndex=1;

	public Index(Long id, int pedagogicalPeriodIndex) {
		super();
		this.id = id;
		this.pedagogicalPeriodIndex = pedagogicalPeriodIndex;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPedagogicalPeriodIndex() {
		return pedagogicalPeriodIndex;
	}

	public void setPedagogicalPeriodIndex(int pedagogicalPeriodIndex) {
		this.pedagogicalPeriodIndex = pedagogicalPeriodIndex;
	}
	
	
}
