package com.abanak.baseClasses;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

import javax.inject.Named;

//@SessionScoped
@Named("BaseBean")
public  abstract class BaseBean implements Serializable
{
	
	private String pageLoadserviceName ;
	private String OID;
	private String nextPAge;
	
	
	private static final long serialVersionUID = 1L;

   public BaseBean()
   {
	   InitializeFlow(); 
	   
	   if( this.getPageLoadserviceName() != null && ! this.getPageLoadserviceName().isEmpty())
		{
		this.setOID(GetOIDFromService(this.getPageLoadserviceName()));
		}
   }
	@Produces
    public void BasePageLoad() 
	{
		String aa= getOID();
    	
    }
	
	private String GetOIDFromService(String pageLoadserviceName2) 
	{
		return  Integer.toString(ThreadLocalRandom.current().nextInt(1000,9999 + 1)); 
		
		
	}

	

  
	public String getNextPAge() {
		return nextPAge;
	}
	public void setNextPAge(String nextPAge) {
		this.nextPAge = nextPAge;
	}
	public String getOID() {
		return OID;
	}
	public void setOID(String oID) {
		OID = oID;
	}

	public String getPageLoadserviceName() {
		return pageLoadserviceName;
	}


	public void setPageLoadserviceName(String pageLoadserviceName) {
		this.pageLoadserviceName = pageLoadserviceName;
	}


	public void BasePostMe(){
		System.out.println("BasePostMe");
		
	}
	public abstract  void InitializeFlow();
		
	
		
	
}
