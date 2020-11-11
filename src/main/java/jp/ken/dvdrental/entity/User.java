package jp.ken.dvdrental.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="user")
public class User {
	
  
	@Id
	@Column(name="user_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_Id;
	
	private String name;
	private String kana;
	private String password;
	private String birth;
	private String gender;
	private String phone;
	private String email;
	private String zip;
	private String address;
	private String plan;
	private int point;
	

	
	
	
	
	
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getKana() {
		return kana;
	}
	public void setKana(String kana) {
		this.kana = kana;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", name=" + name + ", kana=" + kana + ", password=" + password + ", birth="
				+ birth + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", zip=" + zip + ", address="
				+ address + ", plan=" + plan + ", point=" + point + "]";
	}
	
	


}
