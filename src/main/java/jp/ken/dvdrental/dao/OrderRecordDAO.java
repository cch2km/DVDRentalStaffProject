package jp.ken.dvdrental.dao;

import java.util.List;

import jp.ken.dvdrental.entity.OrderRecord;


public interface OrderRecordDAO<T>{
	
	public boolean insertOrderRecordData(OrderRecord oder);
	
	public List<OrderRecord>findOrderByUserId(int userid); 
	
	public int deleteRecord(int id);
	
	
}
