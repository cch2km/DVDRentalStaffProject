package jp.ken.dvdrental.dao;

import java.util.List;

import jp.ken.dvdrental.entity.User;

public interface UserDAO <T> {
	
	public boolean insertUserData(User user);
	
	public User login(String email,String password);
	
	public User getById(int id);
	
	public int updateUser(User user);
	
	public int deleteUser(int id);
	
	public List<T> allList();

}
