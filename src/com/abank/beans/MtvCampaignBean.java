package com.abank.beans;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.abanak.baseClasses.BaseBean;

@Named
//@ConversationScoped
@FlowScoped("mtvCampaignFlow")
public class MtvCampaignBean implements Serializable  {

	private String campaignName;
	@Inject
	private Conversation conversation;
	
	public void initConversation() 
	{
		boolean isPostBack = FacesContext.getCurrentInstance().isPostback();
		//if (!isPostBack && conversation.isTransient()) {
			//conversation.begin();
		//}
	}
	
	

	private static final long serialVersionUID = -7707294980539961950L;
	/*@Override
	public void InitializeFlow() {
		setPageLoadserviceName("MtvCampaignServiceName");
		setCampaignName("MTV Kampnaya");
		
	}*/
	
	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MtvCampaignBean(){
		this.campaignName = "MTV Kampnaya";
		
	}
	

}
