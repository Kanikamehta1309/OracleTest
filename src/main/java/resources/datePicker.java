package resources;

import java.util.List;

import org.openqa.selenium.WebElement;


public class datePicker extends BaseClass {
	
	public WebElement selectDate(List<WebElement> days, String checkinDate) throws InterruptedException {
		WebElement date = null;
		/*
		 * SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); String date
		 * = formatter.format(checkinDate);
		 */
		String splitter[] = checkinDate.split("-");
		//String month_year = splitter[1];
		String day = splitter[0];
			// Selecting the date
			
			for (WebElement d : days) {
					//System.out.println(d.getText());
				if (d.getText().equals(day)) {
					     date =d;
					     //System.out.println(date.getText());
					     break;
					
					  }
					Thread.sleep(10000);
					
				}
			
		return date;

		}

	}

