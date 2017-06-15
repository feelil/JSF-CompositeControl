package com.abank.customConverttors;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.abank.beans.MoneyOrderBean;
import com.abank.pojo.Account;


@FacesConverter(value = "accountConverterOld")
public class AccountConverterOld implements Converter
{

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String arg2) {
		 ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(),
	                                "#{moneyOrderBean}", MoneyOrderBean.class);

	        MoneyOrderBean accounts = (MoneyOrderBean)vex.getValue(ctx.getELContext());
	        return null;//accounts.GetAccount(Integer.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object account) {
		 Account accctemp=((Account)account);
		 Integer accid=accctemp.getAccountId();
		 return accid.toString();
	
	}

}

