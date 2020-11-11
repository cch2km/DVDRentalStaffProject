package jp.ken.dvdrental.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.ken.dvdrental.dao.OrderRecordDAO;
import jp.ken.dvdrental.dao.ProductDAO;
import jp.ken.dvdrental.dao.UserDAO;
import jp.ken.dvdrental.entity.OrderRecord;
import jp.ken.dvdrental.entity.Product;
import jp.ken.dvdrental.entity.User;
import jp.ken.dvdrental.model.ErrorCheckGroup1;
import jp.ken.dvdrental.model.LoginModel;
import jp.ken.dvdrental.model.ProductModel;
import jp.ken.dvdrental.model.UserModel;

@Controller
public class StaffController {
	

	
	private static ApplicationContext context = 
			new ClassPathXmlApplicationContext("spring.xml");

	
	@SuppressWarnings("unchecked")
	private static UserDAO<User> userDAO =
	(UserDAO<User>)context.getBean("userDAO");
	
	@SuppressWarnings("unchecked")
	private static ProductDAO<Product> productDAO =
	(ProductDAO<Product>)context.getBean("productDAO");
	
	@SuppressWarnings("unchecked")
	private static OrderRecordDAO<OrderRecord> orderRecordDAO =
	(OrderRecordDAO<OrderRecord>)context.getBean("orderRecordDAO");
	
	
	@ModelAttribute("loginModel")
	public LoginModel setUpLoginForm() {
		return new LoginModel();
	}
	
	//エラーチェック
	@GroupSequence({Default.class,ErrorCheckGroup1.class})
	interface GroupOrder{}
	
	//ログイン
	@RequestMapping(value="/slogin",method=RequestMethod.GET)
	public String toLogin() {
		return "staffLogin";
	}
	
	
	
	//ログイン
	@RequestMapping(value="/slogin",method = RequestMethod.POST)
    public String Login
    (@Validated @ModelAttribute LoginModel lModel,
    BindingResult result,Model model,HttpSession session) {
        
		if(result.hasErrors()) {
			return"staffLogin";
		}else if(!(lModel.getStaffId().equals("duke") && lModel.getPassword().equals("saikou"))) {
			model.addAttribute("errorMessage", "ユーザーIDもしくはパスワードが間違っています。");
			return "staffLogin";
				
		}else {
			 lModel.setStaffId("duke");
			 lModel.setPassword("saikou");
		    session.setAttribute("staff", lModel);
			return"toMenu";
        	
		}
	}	
	
	//ログアウト
	@RequestMapping(value="/slogout",method=RequestMethod.GET)
	public String logOut(HttpSession session) {
		LoginModel login =(LoginModel)session.getAttribute("staff");
		if(login!=null) 
			session.invalidate();
			return "redirect:/slogin";
		
		
	}
	
	//メニュー
	@RequestMapping(value="/menu",method=RequestMethod.GET)
	public String menu(HttpSession session) {
		LoginModel login =(LoginModel)session.getAttribute("staff");
		if(login==null) {
			return"redirect:/slogin";
		}
		return"toMenu";
	}
		
		//お客様一覧
	 @RequestMapping(value="/userList",method=RequestMethod.GET)
	 	public String userList(Model model,HttpSession session) {
		 LoginModel login =(LoginModel)session.getAttribute("staff");
			if(login==null) {
				return"redirect:/slogin";
			}else {
				List<User> list= userDAO.allList();
				model.addAttribute("message", "お客様一覧表");
				model.addAttribute("userList", list);
	 		
				return"listUserData";
			}
	 	}
	
	 //お客を削除
	@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	public String toDelete(@RequestParam int userId,HttpSession session) {
		LoginModel login =(LoginModel)session.getAttribute("staff");
		if(login==null) {
			return"redirect:/slogin";
		}else {
			
			if(userDAO.deleteUser(userId)==1) {
		return"redirect:/userList";
		}else {
			return"redirect:/userList";
		}
	}
	}
	
	//会員情報変更
		@RequestMapping(value="/editUser",method=RequestMethod.GET)
		public String toEdit(@RequestParam int userId,Model model,HttpSession session) {
			LoginModel login =(LoginModel)session.getAttribute("staff");
			if(login==null) {
				return"redirect:/slogin";
			}else {
			User user= userDAO.getById(userId);
			UserModel uModel = new UserModel();
			BeanUtils.copyProperties(user, uModel);
			uModel.setUser_Id(new Integer(userId).toString());
			model.addAttribute("userModel",uModel);
			return"userEdit";
			}
		}
		
	//お客情報変更
		@RequestMapping(value="/editUser",method=RequestMethod.POST,params="edit")
		public String edit(@Validated
		@ModelAttribute UserModel uModel,BindingResult result,Model model,HttpSession session) {
			LoginModel login =(LoginModel)session.getAttribute("staff");
			if(login==null) {
				return"redirect:/slogin";
			}else {
				User user= new User();
				BeanUtils.copyProperties(uModel, user);
				user.setUser_id(Integer.parseInt(uModel.getUser_Id()));
				if(userDAO.updateUser(user)==1) {
					return"resultDVD";
				}else {
					model.addAttribute("errorMessage", "SQLエラーが発生しています");
					return"redirect:/userList";
				}
			}
		
		}

	
		//在庫登録
		@RequestMapping(value="/proregist",method=RequestMethod.GET)
		public String toRegist(@ModelAttribute ProductModel pModel,Model model,HttpSession session) {
			LoginModel login =(LoginModel)session.getAttribute("staff");
			if(login==null) {
				return "redirect:/slogin";
			}else {
			model.addAttribute("productModel", pModel);
			return "registDVD";
			}	
		}
		
		//在庫登録
		@RequestMapping(value="/proregist",method=RequestMethod.POST)
		public String regist(@Validated(GroupOrder.class)
			@ModelAttribute ProductModel pModel,BindingResult result,Model model,HttpSession session){
			Product product = new Product();
			LoginModel login =(LoginModel)session.getAttribute("staff");
			if(login==null) {
				return"redirect:/slogin";
			 
					
			}else if(result.hasErrors()){
				return"registDVD";
				
				
			}	else {	
				productDAO.updateProduct(product);
						BeanUtils.copyProperties(pModel, product);
						productDAO.insertProductData(product);
						return"resultDVD";
					
			}
			
	}
		
		//在庫商品一覧
		 @RequestMapping(value="/productList",method=RequestMethod.GET)
		 	public String productList(Model model,HttpSession session) {
			 LoginModel login =(LoginModel)session.getAttribute("staff");
				if(login==null) {	
					return"redirect:/slogin";
				}else {
					List<Product> plist= productDAO.allList();
			 		model.addAttribute("message", "在庫商品一覧表");
			 		model.addAttribute("pList", plist);
			 		
			 		return"listProData";
				}
		 	}
		 
		 //在庫商品削除
		 @RequestMapping(value="/deletePro",method=RequestMethod.GET)
			public String deleteProduct(@RequestParam int proId,HttpSession session) {
				LoginModel login =(LoginModel)session.getAttribute("staff");
				if(login==null) {
					return"redirect:/slogin";
				}else {
					
					if(productDAO.deleteProduct(proId)==1) {
				return"redirect:/productList";
				}else {
					return"redirect:/productList";
				}
			}
				
		 }
		 
		 //在庫商品編集表示
		 @RequestMapping(value="/editPro",method=RequestMethod.GET)
			public String edit(@RequestParam int proId,Model model,HttpSession session) {
			 LoginModel login =(LoginModel)session.getAttribute("staff");
				if(login==null) {
					return"redirect:/slogin";
				}else {	
					Product product= productDAO.idSearch(proId);
					ProductModel pModel = new ProductModel();
					BeanUtils.copyProperties(product, pModel);
					//pModel.setProduct_Id(new Integer(proId).toString());
					model.addAttribute("productModel",pModel);
					return"productEdit";
				}
			}
			
	 	//在庫商品編集実行
		@RequestMapping(value="/editPro",method=RequestMethod.POST,params="editProduct")
		public String editPro(@Validated(GroupOrder.class)
		@ModelAttribute ProductModel pModel,BindingResult result,Model model,HttpSession session) {
			Product product= new Product();
			LoginModel login =(LoginModel)session.getAttribute("staff");
			if(login==null) {
				return"redirect:/slogin";
			}else if(result.hasErrors()){
				return"productEdit";
			}else {
				BeanUtils.copyProperties(pModel, product);
				if(productDAO.updateProduct(product)==1)
					return"resultDVD";
				  
				else {
					return"productEdit";
				}
									
			}
			
		}
		
		//レンタル履歴
		@RequestMapping(value="/record",method=RequestMethod.GET)
		public String order(@RequestParam int userId,Model model,HttpSession session) {
			LoginModel login =(LoginModel)session.getAttribute("staff");
			if(login!=null){
				
				List<OrderRecord> list= orderRecordDAO.findOrderByUserId(userId);
				model.addAttribute("olist", "履歴リスト");
				model.addAttribute("rentalList", list);
				return "orderRecord";
			}else {
				return "redirect:/slogin" ;
			}
			
		}	
		
		//レンタル履歴を削除
		
		@RequestMapping(value="/deleteRecord",method=RequestMethod.GET)
		public String delete(@RequestParam int orderId,Model model,HttpSession session) {
			
			LoginModel login =(LoginModel)session.getAttribute("staff");
			if(login==null) {
				return "redirect:/slogin";
			}else{
					
				if(orderRecordDAO.deleteRecord(orderId)==1) {
			
					return "redirect:/userList";
				
			}else {
				//model.addAttribute("errorMessage", "レンタル履歴記録が存在しません");
				return "orderRecord";
			}
			}
			
		}
}
