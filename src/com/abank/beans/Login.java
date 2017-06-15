package com.abank.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.abanak.baseClasses.BaseBean;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class Login extends BaseBean implements Serializable {

	
	


	private String userName;
	private String passWord;

	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	
	public String validateUsernamePassword() throws IOException{
		
	
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if(userName.equals("ilhan") && passWord.equals("1")){
			return "moneyorderFlow";
			//return "/campaign/mtvcampaign/mtvcampaign.xhtml?faces-redirect=true"; 
			//return "/transfer/moneyorder/moneyorder.xhtml?faces-redirect=true"; 
		   
	     
		}
		
		 facesContext.addMessage("loginForm:username", new FacesMessage("Username or password is incorrect"));
		return "Login";
		
		
		
	}


	@Override
	public void InitializeFlow() 
	{
	setUserName("ilhan");
	setPassWord("1");
	setPageLoadserviceName("GerOIDForLogin");
		
	}
    
	

	
	
}
