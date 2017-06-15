package com.abanak.flowdef;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

public class MtvCampaignFlow  implements Serializable{

	
	private static final long serialVersionUID = -5789038035465914705L;
		@Produces
	    @FlowDefinition
	    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) { 
	        String flowId = "mtvCampaignFlow";
	        flowBuilder.id("", flowId);
	        flowBuilder.viewNode("mtvcampaign", "/campaign/mtvcampaign/mtvcampaign.xhtml").markAsStartNode();
	        flowBuilder.viewNode("mtvcampaignP2", "/campaign/mtvcampaign/mtvcampaignP2.xhtml");
	     
	     
	         
	        flowBuilder.returnNode("home") 
	                   .fromOutcome("");
	         
	        return flowBuilder.getFlow();
	    }
}
