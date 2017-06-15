package com.abanak.flowdef;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

public class MoneyorderFlow implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	 
	    @Produces
	    @FlowDefinition
	    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) { 
	        String flowId = "moneyorderFlow"; 
	        flowBuilder.id("", flowId);
	        flowBuilder.viewNode("start", "/transfer/moneyorder/moneyorder.xhtml").markAsStartNode();
	        flowBuilder.viewNode("confirm", "/transfer/moneyorder/moneyorder-confirm.xhtml");
	     
	     
	         
	        flowBuilder.returnNode("home") 
	                   .fromOutcome("");
	         
	        return flowBuilder.getFlow();
	    }
}
