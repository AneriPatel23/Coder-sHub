package VO;

import java.io.Serializable;

public class ComplainVO {
	
	private int complainId;
	private String subject;
	private String description;
	private String other;
	private LoginVO toUserId;
	public LoginVO getToUserId() {
		return toUserId;
	}
	public void setToUserId(LoginVO toUserId) {
		this.toUserId = toUserId;
	}
	public LoginVO getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(LoginVO fromUserId) {
		this.fromUserId = fromUserId;
	}
	private LoginVO fromUserId;
	
	public int getComplainId() {
		return complainId;
	}
	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	
	
}
