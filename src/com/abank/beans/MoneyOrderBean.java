package com.abank.beans;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.http.client.ClientProtocolException;

import com.abanak.baseClasses.BaseBean;
import com.abank.pojo.Account;

@Named
@FlowScoped("moneyorderFlow")
public class MoneyOrderBean extends BaseBean implements Serializable {

	@Inject
	private Conversation conversation;

	private static final long serialVersionUID = 3325530601606688001L;
	private Account sourceAccount;
	private Date selectedDate;
	private String orderType;
	private String targetIBAN;
	private BigDecimal amount;
	private String explanation;
	private List<Account> accounts;
	private String nextPage;

	@Override
	public void InitializeFlow() {
		setPageLoadserviceName("MoneyOrderServiceName");

	}

	public void initConversation() {
		boolean isPostBack = FacesContext.getCurrentInstance().isPostback();
		if (!isPostBack && conversation.isTransient()) {
		//	conversation.begin();
		}
	}

	public String endConversation() {
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "moneyorder?faces-redirect=true";
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTargetIBAN() {
		return targetIBAN;
	}

	public void setTargetIBAN(String targetIBAN) {
		this.targetIBAN = targetIBAN;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	public Account getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public String getReturnValue() {
		return "/home";
	}

	public Account GetAccount(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("no id provided");
		}
		for (Account acc : accounts) {
			if (id.equals(acc.getAccountId())) {
				return acc;
			}
		}
		return null;
	}
	/*
	 * public List<Account> getCustomerAccounts(){ List<Account> rValue=new
	 * ArrayList<Account>(); Account tempAcc=null; for (int i = 0; i < 5; i++) {
	 * tempAcc=new Account(); tempAcc.setAccountId(i);
	 * tempAcc.setAccountNumber(i + "456-789"); tempAcc.setCurrencyCode("TRY");
	 * tempAcc.setIbanNumber("TR-" + i + "- 98583213213223");
	 * rValue.add(tempAcc); }
	 * 
	 * return rValue; }
	 */

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void listen(AjaxBehaviorEvent e) {

		String bb = "";
		String cc=bb;

	}

	public String Confirm() throws ClientProtocolException, IOException {

		return "confirm";
		/*
		 * ObjectMapper mapper = new ObjectMapper(); DateFormat df = new
		 * SimpleDateFormat("yyyy-MM-dd"); mapper.setDateFormat(df); String
		 * jsonInString = mapper.writeValueAsString(this);
		 * 
		 * HttpClient httpClient = HttpClientBuilder.create().build(); HttpPost
		 * post=new HttpPost("http://localhost:8088/ServletSample/Dispatcher");
		 * 
		 * StringEntity requestBody =new StringEntity(jsonInString);
		 * post.addHeader("content-type", "application/x-www-form-urlencoded");
		 * post.setEntity(requestBody); HttpResponse httpResponse =
		 * httpClient.execute(post);
		 * 
		 * BufferedReader rd = new BufferedReader( new
		 * InputStreamReader(httpResponse.getEntity().getContent()));
		 * 
		 * StringBuffer result = new StringBuffer(); String line = ""; while
		 * ((line = rd.readLine()) != null) { result.append(line); }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * try {
		 * 
		 * mapper.readerForUpdating(this).readValue(result.toString()); } catch
		 * (JsonProcessingException e) { // throw e; }
		 * 
		 * 
		 * System.out.println(result.toString()); return "confirm";
		 */
	}

	public String execute() throws IOException {

		return "moneyorder";
	}
	private String page;

    public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@PostConstruct
    public void init() {
        page = "mtvcampaign"; //  Default include.
    }


}
