package com.abank.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.abank.pojo.MenuItem;

@Named
@ApplicationScoped
public class MenuBean implements Serializable {

	
	
	private List<MenuItem> menuitems;
 

	@PostConstruct
	public void init() {
	 
	 menuitems=new ArrayList<MenuItem>();
	 MenuItem tempItem=null;
	

		 tempItem=new MenuItem();
		 tempItem.setId(1) ;
		 tempItem.setText("Hesaplar");
		 menuitems.add(tempItem);
		 tempItem=new MenuItem();
		 tempItem.setId(2);
		 tempItem.setText("Para Transferleri");
		 menuitems.add(tempItem);
		 tempItem=new MenuItem();
		 tempItem.setId(3);
		 tempItem.setText("Kredi Kartlarý");
		 menuitems.add(tempItem);
		 tempItem=new MenuItem();
		 tempItem.setId(4);
		 tempItem.setText("Ödemeler");
		 menuitems.add(tempItem);
	 
 }


public List<MenuItem> getMenuitems() {
	return menuitems;
}


public void setMenuitems(List<MenuItem> menuitems) {
	this.menuitems = menuitems;
}


}
