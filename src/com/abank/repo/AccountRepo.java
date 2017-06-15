package com.abank.repo;

import java.util.ArrayList;
import java.util.List;

import com.abank.pojo.Account;

public class AccountRepo 
{
	
	private static List<Account> accounts;
	public static  List<Account> AccountComponentLoadDataFromService(String attr) 
	{

		accounts = new ArrayList<Account>();
		Account tempAcc = null;
		
		String tempCode = "YTL";
		if(attr.equals("YTL") || attr.equals("ALL"))
		{
			tempCode = "YTL";
		for (int i = 10; i < 14; i++)
		{
			
			tempAcc = new Account();
			tempAcc.setAccountName(tempCode + " " + i + " Hasabý ");
			tempAcc.setAccountId(i);
			tempAcc.setAccountNumber(i + "-456-789");
			tempAcc.setCurrencyCode(tempCode);
			tempAcc.setIbanNumber(tempCode + " " + i + "-98583213213223");

			accounts.add(tempAcc);

		}
		}
		if(attr.equals("USD")){
		 tempCode = "USD";
		for (int i = 14; i < 18; i++){
			
			tempAcc = new Account();
			tempAcc.setAccountName(tempCode + " " + i + " Hasabý ");
			tempAcc.setAccountId(i);
			tempAcc.setAccountNumber(i + "-456-789");
			tempAcc.setCurrencyCode(tempCode);
			tempAcc.setIbanNumber(tempCode + " " + i + "-98583213213223");

			accounts.add(tempAcc);

		}
		}
		return accounts;

	}
}
