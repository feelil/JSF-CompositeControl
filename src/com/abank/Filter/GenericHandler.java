package com.abank.Filter;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.Bean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.abanak.baseClasses.BaseBean;
import com.abank.beans.Login;
import com.abank.beans.MoneyOrderBean;

@WebFilter("/aa*")
public class GenericHandler implements Filter , Serializable	 {

	
	 @Inject 
     private Instance<BaseBean> baseBean;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		 String servletPath = req.getServletPath();
		  
	        // The path to the root directory of the webapp (WebContent)
	        String realRootPath = request.getServletContext().getRealPath("");
	 
	   
	
	        baseBean.get().setOID("aaa");
	        chain.doFilter(request, response);
	        
	      
		
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	@SuppressWarnings("unchecked")
	public static <T> T findBean(String beanName) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    if(context == null)
	    	return null;
	    return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	}

}
