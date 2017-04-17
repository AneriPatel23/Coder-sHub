package VO;

import java.io.Serializable;

public class CompanyVO implements Serializable{
	
	CountryVO cv;
	StateVO sv;
	private int companyId;
	private String companyName;
	private String address;

	
	LoginVO loginVO;
	
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
	public CountryVO getCv() {
		return cv;
	}
	public void setCv(CountryVO cv) {
		this.cv = cv;
	}
	public StateVO getSv() {
		return sv;
	}
	public void setSv(StateVO sv) {
		this.sv = sv;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
