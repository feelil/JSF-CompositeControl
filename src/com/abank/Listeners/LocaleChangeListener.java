package com.abank.Listeners;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class LocaleChangeListener implements ValueChangeListener {

	@Override
	public void processValueChange(ValueChangeEvent e) throws AbortProcessingException {
		String aa="";	
		
		
		
		Object newValue=e.getNewValue();
		Object oldValue=e.getOldValue();
		String bb="";
		bb=aa;
	}

}
