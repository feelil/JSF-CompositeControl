package com.abank.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

import com.abanak.baseClasses.BaseBean;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class Test extends BaseBean implements Serializable {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void postme() {
		System.out.println("POST ME" );
	}

	@Override
	public void InitializeFlow() {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void init() {
		setPageLoadserviceName("GerOIDForTest");
		
	
	}	*/

	
}
