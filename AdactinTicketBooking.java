package Maven;

import java.awt.AWTException;

import org.openqa.selenium.By;

public class AdactinTicketBooking extends BaseClass    {

		
			public static void main(String[] args) throws AWTException, InterruptedException {

				BaseClass b = new BaseClass();
				driver = browserLaunch("chrome");
				getmethod("https://adactinhotelapp.com/");
				sendkey(driver.findElement(By.id("username")),"Suriyaprabhu" );
				sendkey(driver.findElement(By.id("password")), "85S3R3");
				clickelement(driver.findElement(By.id("login")));
				select(driver.findElement(By.id("location")),"Sydney" , "value");
				b.selectedoption(driver.findElement(By.id("location")));
//				select(driver.findElement(By.id("hotels")), "Hotel Sunshine", "value");
//				select(driver.findElement(By.id("room_type")), "Deluxe", "value");
//				select(driver.findElement(By.id("room_nos")), "2", "index");
//				sendkey(driver.findElement(By.name("datepick_in")), "12/04/2022");
//				sendkey(driver.findElement(By.id("datepick_out")), "17/04/2022");
//				select(driver.findElement(By.id("adult_room")),"2" , "value");
//				select(driver.findElement(By.id("child_room")), "2", "index");
//				clickelement(driver.findElement(By.id("Submit")));
//				radiobutton(driver.findElement(By.id("radiobutton_0")));
//				clickelement(driver.findElement(By.id("continue")));
//				sendkey(driver.findElement(By.name("first_name")), "suriya");
//				sendkey(driver.findElement(By.name("last_name")), "periyasamy");
//				sendkey(driver.findElement(By.name("address")), "Mandaiyaman Kovil Street");
//				sendkey(driver.findElement(By.name("cc_num")), "1234567890123456");
//				select(driver.findElement(By.id("cc_type")), "American Express", "visible");
//				select(driver.findElement(By.id("cc_exp_month")), "1", "value");
//				select(driver.findElement(By.id("cc_exp_year")),"2013" , "value");
//				sendkey(driver.findElement(By.name("cc_cvv")), "998");
//				clickelement(driver.findElement(By.id("book_now")));
//				
//				implicitwait();
//				clickelement(driver.findElement(By.id("my_itinerary")));
				b.windowhandel();
				getUrl();
				b.windowshandeles("\"Adactin.com - Hotel Reservation System\"");
				

				System.out.println("completed");
				
				
				

		}

	}



