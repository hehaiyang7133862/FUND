package com.laungee.proj.common.model;

import java.util.Date;
import java.util.Set;

/**
 * TbAcademy generated by MyEclipse Persistence Tools
 */

public class TbZcprojType implements java.io.Serializable {

	// Fields

	private Long typeId;
	private String typeCode;
	private String typeName;
	private Long parentId;
	private Long numOrder;
	private String memo;
	private Long creationUser;
	private String creationTime;
	private Long updateUser;
	private Date updateTime;
	private Set children;

	// Constructors

	public TbZcprojType() {
	}

	// Property accessors

	public Long getTypeId() {
		return typeId;
	}
	
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeCode() {
		return typeCode;
	}
	
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	public Long getParentId() {
		return parentId;
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	public Long getNumOrder() {
		return numOrder;
	}
	
	public void setNumOrder(Long numOrder) {
		this.numOrder = numOrder;
	}
	
	public Long getCreationUser() {
		return creationUser;
	}
	
	public void setCreationUser(Long creationUser) {
		this.creationUser = creationUser;
	}
	
	public String getCreationTime() {
		return creationTime;
	}
	
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	
	public Long getUpdateUser() {
		return updateUser;
	}
	
	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public Set getChildren() {
		return children;
	}
	
	public void setChildren(Set children) {
		this.children = children;
	}
	
}