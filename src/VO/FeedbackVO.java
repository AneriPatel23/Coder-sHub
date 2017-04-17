package VO;

public class FeedbackVO {
	
	private int feedbackId;
	private String feedback;
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
	
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}
