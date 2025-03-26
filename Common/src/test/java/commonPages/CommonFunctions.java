package commonPages;

import java.util.Random;



public class CommonFunctions{
	 
	public static String generateRandomEmail() {
	        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	        Random random = new Random();
	        StringBuilder emailPrefix = new StringBuilder();

	        // Generate a random email prefix (e.g., username part)
	        for (int i = 0; i < 10; i++) {  // You can adjust the length
	            int index = random.nextInt(characters.length());
	            emailPrefix.append(characters.charAt(index));
	        }

	        // Use a random domain
	        String domain = "@example.com";  // You can use other domains or make it random too
	        
	        return emailPrefix.toString() + domain;
	    }

}
