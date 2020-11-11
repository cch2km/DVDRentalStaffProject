package jp.ken.dvdrental.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class DvdRentalModel implements Serializable {
	
	
	@NotEmpty(message="省略する事はできません。")
	private String vagueFiled;

	
	
	public String getVagueFiled() {
		return vagueFiled;
	}

	public void setVagueFiled(String vagueFiled) {
		this.vagueFiled = vagueFiled;
	}

}
