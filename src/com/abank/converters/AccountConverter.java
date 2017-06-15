package com.abank.converters;



import java.io.Serializable;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.abank.customcontrols.AccountComponent;
import com.abank.pojo.Account;


@FacesConverter(value = "AccountConverter", forClass=Account.class)
public class AccountConverter implements Converter,Serializable 
{

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String arg2) 
	{		  
		ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(),"#{AccountComponent}", AccountComponent.class);
		 
		 AccountComponent accComponent = (AccountComponent)vex.getValue(ctx.getELContext());		 		
		 Account racc=accComponent.GetAccount(Integer.valueOf(arg2));
	        return racc;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object account) {
		  
		 Account accctemp=((Account)account);
		 Integer accid=accctemp.getAccountId();
		 return accid.toString();
	
	}

}
