package jp.ken.dvdrental.dao;

import java.util.List;


import jp.ken.dvdrental.entity.Product;


public interface ProductDAO<T> {
	
	public Product idSearch(int id);
	
	//商品名で検索
	public Product nameSearch(String product_name);
	
	//監督で検索
	public List<T> directorSearch(String dir);
	
	//あいまい商品名検索
	public List<T> vagueNameList(String vague1);
	
	//商品一覧
	public List<T> allList();
	
	//商品削除
	public int deleteProduct(int product_Id);
	
	//商品編集
	public int updateProduct(Product product);
	
	
	//在庫商品登録
	public boolean insertProductData(Product product);
	
	//在庫更新
	public void updateNum(Product product) ;

}
