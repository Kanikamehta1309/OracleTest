package pageObjects;

import java.util.Random;

public class Generic {
	public static String username = "Trivago";
	public static String newEmailId = null;
	public static String newPassword = null;
	public static String firstName = null;
	public static String lastName = null;
	public static String phoneNumber = null;

	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000000000);
	
	
	public String randomEmailId(){
	
		newEmailId = username + randomInt + "@gm.com";
		return newEmailId;
	}
	
	public String randomPassword(){
		newPassword = username + "@" + randomInt;
		return newPassword;
	}
	
	public String firstName(){
		firstName = getRandomString(10);
		return firstName;
	}
	public String lastName(){
		lastName = getRandomString(10);
		return lastName;
	}
	public String phoneNum(){
		phoneNumber = randomInt + "";
		return phoneNumber;
	}
	
	 
	    // function to generate a random string of length n 
	   public static String getRandomString(int n) 
	    { 
	  
	        // chose a Character random from this String 
	        String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	                                     
	  
	        // create StringBuffer size of AlphaNumericString 
	        StringBuilder sb = new StringBuilder(n); 
	  
	        for (int i = 0; i < n; i++) { 
	  
	            // generate a random number between 
	            // 0 to AlphaNumericString variable length 
	            int index 
	                = (int)(AlphaString.length() 
	                        * Math.random()); 
	  
	            // add Character one by one in end of sb 
	            sb.append(AlphaString 
	                          .charAt(index)); 
	        } 
	  
	        return sb.toString(); 
	    } 
	  
}
