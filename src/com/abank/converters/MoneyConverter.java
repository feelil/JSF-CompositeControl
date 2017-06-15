package com.abank.converters;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;



@FacesConverter(value = "MoneyConverter")
public class MoneyConverter implements Converter,Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6390733859967888814L;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		if(arg2.equals(""))
			return null;
		arg2=arg2.replaceAll("\\.","" );
		arg2 = arg2.replaceAll(",", "\\.");
		BigDecimal bigDecimalValue= new BigDecimal(arg2);
		
		return bigDecimalValue;
		//return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
