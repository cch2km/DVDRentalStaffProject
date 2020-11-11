package jp.ken.dvdrental.entity;

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
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int order_Id;
	
	
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="product_Id",insertable=false,updatable=false)
	private Product product;
	
	
	@OneToOne
	@JoinColumn(name="id",insertable=false,updatable=false)
	private OrderRecord order;
	
	private int num;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OrderRecord getOrder() {
		return order;
	}
	public void setOrder(OrderRecord order) {
		this.order = order;
	}
	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}


	
	
}
