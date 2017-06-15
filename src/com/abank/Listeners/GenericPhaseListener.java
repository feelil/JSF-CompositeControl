package com.abank.Listeners;

import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.abanak.baseClasses.BaseBean;

public class GenericPhaseListener implements PhaseListener {

	
	 @Inject 
     private Instance<BaseBean> baseBean;
	
	private static final long serialVersionUID = -9087687201751234269L;

	@Override
	public void beforePhase(PhaseEvent event) 
	{
		String s1 = "";
		FacesContext fc = event.getFacesContext();	
		
		if(fc.isPostback())
		{
			
		}
		
		 System.out.println(event.getPhaseId() + " Before");
		// processViewTree(event.getFacesContext().getViewRoot());
		
		 /*
		 BaseBean tbena = getBean(BaseBean.class);
			if (tbena != null) {
				s1= tbena.getPageLoadserviceName();
				}
				*/
				
			
			
				

	}

	@Override
	public void afterPhase(PhaseEvent event) {
		
		 System.out.println(event.getPhaseId() +" After");
		 String s1="";
		 
		 processViewTree(event.getFacesContext().getViewRoot());
		 
		
		    /*
			BaseBean tbena = getBean(BaseBean.class);
			if (tbena != null) {			
				s1=	tbena.getPageLoadserviceName();
				
			
			}
			*/
		
	}

	@Override
	public PhaseId getPhaseId() {

		return PhaseId.RENDER_RESPONSE;
	}

	
	
	 private void processViewTree(UIComponent component) {
	       
	        for (UIComponent child: component.getChildren()) {
	            // Display component ID and its type
	           // System.out.println("+ " + child.getId() + " ["+child.getClass()+"]");
	             if("txtserviceName".equals( child.getId())){
	            	 
	            	  HtmlInputText inputText     = (HtmlInputText)child;
	            	  String val = inputText.getValue().toString();
	            	  String OID="AAA123";
	            	  baseBean.get().setOID(OID);
	            	  String aa=val;
	             }
	           
	          
	             
	            // Process next node
	            processViewTree(child);
	        }
	    }
	public BeanManager getBeanManager() {
		BeanManager beanManager = null;
		try {
			InitialContext initialContext = new InitialContext();
			beanManager = (BeanManager) initialContext.lookup("java:comp/BeanManager");
		} catch (NamingException e) {
			// logger.log(Level.SEVERE, "Couldn't get BeanManager through JNDI",
			// e);
		}
		return beanManager;
	}

	


	
	public <T> T getBean(final Class<T> clazz) {
		BeanManager bm = getBeanManager();
		
		Bean<T> bean = (Bean<T>) bm.getBeans(clazz).iterator().next();
		 Context context = bm.getContext(ViewScoped.class);
		CreationalContext<T> ctx = bm.createCreationalContext(bean);
		return (T) bm.getReference(bean, clazz, ctx);
	}
	private UIComponent findComponent(UIComponent root, String id) {

		UIComponent result = null;
		if (root.getId().equals(id))
		return root;

		for (UIComponent child : root.getChildren()) {
		if (child.getId().equals(id)) {
		result = child;
		break;
		}
		result = findComponent(child, id);
		if (result != null)
		break;
		}
		return result;
		}
}
