package jp.ken.dvdrental.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="orderrecord")
public class OrderRecord {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	
	private int total;
//	private String receiverAddress;
//	private String receiver_name;
//	private String receiverPhone;
	private Date orderTime;
	private Date returnTime;
	private int user_Id;
	
	
	@OneToOne
	@JoinColumn(name="user_Id",insertable=false,updatable=false)
	private User user;
	
//	@OneToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name="detail_Id", insertable=false,updatable=false)
//	private List<Item> product = new ArrayList<Item>();
	
	

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}



//	public String getReceiver_name() {
//		return receiver_name;
//	}
//
//	public void setReceiver_name(String receiver_name) {
//		this.receiver_name = receiver_name;
//	}



	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}




	


	

	
	

}
