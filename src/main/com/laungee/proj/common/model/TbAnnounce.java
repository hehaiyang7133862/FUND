package com.laungee.proj.common.model;

import java.util.Date;

/**
 * TbAnnounce generated by MyEclipse Persistence Tools
 */

public class TbAnnounce implements java.io.Serializable {

	// Fields

	private Long announceId;
	private TbCommunity tbCommunity;
	private String subject;
	private String centent;
	private Date createDate;
	private Long updateUser;
	private Date updateTime;
	private Long typeFid;
	private Long creationUser;
	private String creationTime;
	// Constructors

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
	// Constructors

	/** default constructor */
	public TbAnnounce() {
	}

	/** minimal constructor */
	public TbAnnounce(Long announceId) {
		this.announceId = announceId;
	}

	/** full constructor */
	public TbAnnounce(Long announceId, TbCommunity tbCommunity, String subject,
			String centent, Date createDate, Long updateUser, Date updateTime) {
		this.announceId = announceId;
		this.tbCommunity = tbCommunity;
		this.subject = subject;
		this.centent = centent;
		this.createDate = createDate;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Long getAnnounceId() {
		return this.announceId;
	}

	public void setAnnounceId(Long announceId) {
		this.announceId = announceId;
	}

	public TbCommunity getTbCommunity() {
		return this.tbCommunity;
	}

	public void setTbCommunity(TbCommunity tbCommunity) {
		this.tbCommunity = tbCommunity;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCentent() {
		return this.centent;
	}

	public void setCentent(String centent) {
		this.centent = centent;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getTypeFid() {
		return typeFid;
	}

	public void setTypeFid(Long typeFid) {
		this.typeFid = typeFid;
	}
     
}