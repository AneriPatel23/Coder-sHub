package VO;

import java.io.Serializable;

public class StateVO implements Serializable {

	CountryVO cv;
	private int stateId;
	private String stateName;
	private String description;
	
	
	public CountryVO getCv() {
		return cv;
	}
	public void setCv(CountryVO cv) {
		this.cv = cv;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
