package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	 @DataProvider(name="dp")
	  Object[][] loginData()
	  {
		  Object[][] data= {
				  {"L6wpYkwItw@gm.com","password","EWGKhjeZEC","valid"},
				  {"L6wpYkwItw@gm.com","passw","EWGKhjeZEC","invalid"},
				  {"L6wpYkwItw@yah.com","password","EWGKhjeZEC","invalid"},
				  {"L6wpYkwItw@gm.com","password","EWGKhjeZEC","invalid"},  
				  {"L6wpYkwItw@gm.com","assword","EWGKhjeZEC","valid"}
		  };		  
		  return data;
	  }
	 
	 @DataProvider(name="dp2", indices={2,3})
	  Object[][] loginData2()
	  {
		  Object[][] data= {
				  {"email1", "password1"},
				  {"email2", "password2"},
				  {"email3", "password3"},
				  {"email4", "password4"}			  
		  };		  
		  return data;
	}
}
