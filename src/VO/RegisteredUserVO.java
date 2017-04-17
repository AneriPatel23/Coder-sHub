package VO;

import java.util.Date;

public class RegisteredUserVO
{
	/*CountryVO cv;
	StateVO sv;*/
	private int registeredUserId;
	private String firstName;
	private String lastName;
	/*private Date dateOfBirth;*/
	
	private int phoneNumber;
	/*private String address;*/
	private LoginVO loginVO;
	
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
/*	public CountryVO getCv() {
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
	}*/
	public int getRegisteredUserId() {
		return registeredUserId;
	}
	public void setRegisteredUserId(int registeredUserId) {
		this.registeredUserId = registeredUserId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
/*	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}*/
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
/*	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	*/
	
	
	
}
