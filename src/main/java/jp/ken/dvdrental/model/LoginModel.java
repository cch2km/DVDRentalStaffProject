package jp.ken.dvdrental.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginModel implements Serializable {
	
	@NotEmpty(message="ユーザーIDを入力してください")
	private String staffId;
	
	@NotEmpty(message="パスワードを入力してください")
	private String password;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
