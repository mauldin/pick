/**
 * TestEntity.java
 *
 * Copyright (c) 2014 - Old Dominion Freight Line
 *
 */
package com.odfl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Enter type doc here.
 * 
 * $Header$
 *
 */
@Entity
@Table(name="test",schema="sam")
public class TestEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@Column(name = "id")
	private Integer id;
	@NotNull
	@Size(min = 0, max = 20)
	@Column(name = "name")
	private String name;
	/**
	 * @return the id
	 */
	public TestEntity() {
		name = "";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestEntity [id=" + id + ", name=" + name + "]";
	}
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
