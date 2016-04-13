package com.laungee.proj.common.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.lob.SerializableClob;

import com.laungee.proj.common.biz.ICommonBiz;
import com.laungee.proj.common.util.SpringUtil;
import com.laungee.proj.common.util.StringUtil;

/**
 * TbAction generated by MyEclipse Persistence Tools
 */

/**
 * @author Administrator
 *
 */
public class TbAction implements java.io.Serializable {

	// Fields

	private Long actionId;
	private String subject;
	private Date startDate;
	private Date endDate;
	private String address;
	private String content;
	private String keys;
	private String memo;
	private Long joinCount;
	private Long typeFid;
	private Long updateUser;
	private Date updateTime;
	private Set tbActionAlumnis = new HashSet(0);
	private Long creationUser;
	private String creationTime;
	private Long isStop;
	private Long isPublic;
	private Long actionFlag;
	private Long gljd;//��������
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
	public TbAction() {
	}

	public Long getActionId() {
		return this.actionId;
	}

	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		if(actionId!=null&&!"".equals(actionId)){
			ICommonBiz biz=(ICommonBiz)SpringUtil.getBean("commonBiz");
			Object obj=null;
			try {
				obj=biz.getSQLUnique("select content from tb_action a where a.action_id="+new Long(actionId));
				if(obj!=null){
					//SerializableClob clob=new SerializableClob((CLOB)obj);
					SerializableClob serClob = (SerializableClob)obj;
					content=StringUtil.clobToString(serClob);
				}
			} catch (Exception e) {
				e.printStackTrace();
				if("java.lang.String".equalsIgnoreCase(e.getMessage())){
					//�����ת��������obj��ֵ����content
					content=obj+"";
				}
			}
		}
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Long getJoinCount() {
		return this.joinCount;
	}

	public void setJoinCount(Long joinCount) {
		this.joinCount = joinCount;
	}

	public Long getTypeFid() {
		return this.typeFid;
	}

	public void setTypeFid(Long typeFid) {
		this.typeFid = typeFid;
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

	public Set getTbActionAlumnis() {
		return this.tbActionAlumnis;
	}

	public void setTbActionAlumnis(Set tbActionAlumnis) {
		this.tbActionAlumnis = tbActionAlumnis;
	}

	public Long getIsStop() {
		return isStop;
	}

	public void setIsStop(Long isStop) {
		this.isStop = isStop;
	}

	public Long getActionFlag() {
		return actionFlag;
	}

	public void setActionFlag(Long actionFlag) {
		this.actionFlag = actionFlag;
	}

	public Long getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Long isPublic) {
		this.isPublic = isPublic;
	}

	public Long getGljd() {
		return gljd;
	}

	public void setGljd(Long gljd) {
		this.gljd = gljd;
	}
	
}