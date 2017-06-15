package com.abank.customcontrols;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.el.MethodExpression;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import org.codehaus.jackson.map.ObjectMapper;



import com.abank.pojo.Account;
import com.abank.repo.AccountRepo;


@Named("AccountComponent")
@RequestScoped
@FacesComponent("AccountComponent")
public class AccountComponent extends UIInput implements NamingContainer {



	private List<Account> accounts;
	

	public void init() {
		String attr = this.getAttributeValue("CurrencyCode", "ALL");
		accounts=AccountRepo.AccountComponentLoadDataFromService(attr);
	}
	
	public Account GetAccount(Integer id) {

		if (id == null) {
			throw new IllegalArgumentException("no id provided");
		}
		if (accounts == null)
			return null;
		for (Account acc : accounts) {
			if (id.equals(acc.getAccountId())) {
				return acc;

			}
		}
		return null;
	}

	@Override
	public String getFamily() {
		return UINamingContainer.COMPONENT_FAMILY;
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		Object obj = getValue();

		UIInput drpAccount = (UIInput) findComponent("drpAccount");
		if (obj != null && drpAccount != null)
			drpAccount.setValue(obj);

		super.encodeBegin(context);
	}

	@Override
	public Object getSubmittedValue() 
	{
		UIInput drp = (UIInput) findComponent("drpAccount");
		Integer accId = Integer.parseInt(drp.getSubmittedValue().toString());
		Account acc=this.GetAccount(accId);
		return acc;
		//return this;
	}
	
	/**
	 * Converts the submitted value to concrete instance.
	 */
	@Override
	protected Object getConvertedValue(FacesContext context, Object submittedValue) {

		/*UIInput drp = (UIInput) findComponent("drpAccount");
		Integer accId = Integer.parseInt(drp.getSubmittedValue().toString());

		AccountComponent acc = (AccountComponent) submittedValue;
		Account racc = acc.GetAccount(accId);*/
		return submittedValue;
	}

	// Helpers
	// ------------------------------------------------------------------------------------

	/**
	 * Return specified attribute value or otherwise the specified default if
	 * it's null.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private <T> T getAttributeValue(String key, T defaultValue) {
		T value = (T) getAttributes().get(key);
		return (value != null) ? value : defaultValue;
	}

	public String GetJsonFromObject() {

		return this.toString();

	}
	// Getters/setters
	// ----------------------------------------------------------------------------

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		mapper.setDateFormat(df);
		String jsonInString = "";
		try {
			jsonInString = mapper.writeValueAsString(this.accounts);
		} catch (Exception e) {
		}
		return jsonInString;
	}

	

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	/*
	 * public String getCurrencyCode() { return currencyCode; }
	 * 
	 * public void setCurrencyCode(String currencyCode) { this.currencyCode =
	 * currencyCode; }
	 */

}
