package time_application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Te {
	public static void main(String args[]) {
		
		/*
		 ArrayList<Integer> myNumbers = new ArrayList<Integer>();
		    myNumbers.add(1900);
		    myNumbers.add(4821);
		    myNumbers.add(10600);
		    myNumbers.add(4000);
		    myNumbers.add(19900);
	        
	        System.out.println(myNumbers);
	        
	        double sum = 0;
	        for(int i = 0; i < myNumbers.size(); i++)
	        {
	         sum = sum +(double) myNumbers.get(i);
	        }
	        System.out.println(sum);
	      
		ArrayList<String> myNumbers = new ArrayList<String>();
	    myNumbers.add("1900");
	    myNumbers.add("4821");
	    
	    System.out.println(   myNumbers  );
	    
	    ArrayList<Integer> numbers = new ArrayList<Integer>();

	    for(int i = 0; i < myNumbers.size(); i++) {
	       numbers.add(Integer.parseInt(myNumbers.get(i)));   
	    }
	    System.out.println(   numbers  );
	    
		
	  	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("-MMM");
	    LocalDateTime now2 = LocalDateTime.now();
	    String date_and_time2 = dtf.format(now2);
	    System.out.println(date_and_time2 );
	    
	   

		 Calendar calendar = Calendar.getInstance();  
	        int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR); 
	        int b = --weekNumber;
	        String a ="Week "+b+"";
	        System.out.println(a);
	        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy");
        LocalDateTime now1= LocalDateTime.now().minusDays(1);
        String date_and_time = dtf.format(now1);
        System.out.println(date_and_time);
        */
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
   		LocalDateTime now = LocalDateTime.now().minusDays(1);
   		String date_and_time = dtf.format(now);
   		System.out.println(date_and_time);
	    
	}
	}
