package Maven;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
		public static WebDriver driver;

		public static WebDriver browserLaunch(String browser) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\ELCOT\\eclipse-workspace new\\Adactin_Newproject\\Driver\\new chromedriver\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox"))
					{
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\ELCOT\\eclipse-workspace\\Maven\\Driver\\Firefox\\geckodriver.exe");
				driver = new FirefoxDriver();
				
			}
				
				else {
			
				System.out.println("browser not installed in your System");
			}
			driver.manage().window().maximize();
			return driver;
		}

		public static void getmethod(String url) {
			driver.get(url);
		}

		public static void navigate(String url) {
	//Navigate the browsing page back,forward
			driver.navigate().to(url);
			

			driver.navigate().forward();
			

		}
		public static void navigateback(String url) {
			driver.navigate().to(url);
			driver.navigate().back();
		}
		public static void refresh(String url) {
			driver.navigate().to(url);
			driver.navigate().refresh();
		}

		public void alertBox(WebElement element, WebElement element2, String text) {
			element.click();
			element2.click();

			if (text.equalsIgnoreCase("ok")) {
				driver.switchTo().alert().accept();

			} else if (text.equalsIgnoreCase("no")) {
				driver.switchTo().alert().dismiss();
			} else if (text.equalsIgnoreCase("welcome")) {
				driver.switchTo().alert().sendKeys("welcome");
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();

			}

		}

		public static void action(String action, WebElement element) throws AWTException {

			Actions a = new Actions(driver);
			Robot r = new Robot();
			if (action.equalsIgnoreCase("down")) {
				a.contextClick(element).build().perform();

				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			} else {
				a.contextClick(element).build().perform();
				r.keyPress(KeyEvent.VK_UP);
				r.keyRelease(KeyEvent.VK_UP);
				r.keyPress(KeyEvent.VK_UP);
				r.keyRelease(KeyEvent.VK_UP);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			}

		}

		public void frame(WebElement element, WebElement framelement) {
			element.click();

			driver.switchTo().frame(framelement);
			framelement.click();
			framelement.sendKeys("first fram");
			

		}

		public void close() {

			driver.close();
		}

		public static void select(WebElement element, String value, String selectvalue) {
			Select s = new Select(element);
			element.click();
			
			if (selectvalue.equalsIgnoreCase("value")) {
				s.selectByValue(value);
				
			}else if(selectvalue.equalsIgnoreCase("visible")) {
				s.selectByVisibleText(value);
			}else if(selectvalue.equalsIgnoreCase("index")) {
			
				int index = Integer.parseInt(value);
				s.selectByIndex(index);
			}
			else {
				System.out.println("Invalid select");
			}

		}
		
		public void windowshandeles(String windowtitle) {
			//String firstwindow = driver.getWindowHandle();
			Set<String> id = driver.getWindowHandles();
			for (String window : id) {
				String title = driver.switchTo().window(window).getTitle();	
				
				System.out.println(title);
				if(title.equals(windowtitle)) {
					driver.close();
				}
				
			}//driver.switchTo().window(firstwindow);
			
		}
		public void windowhandel() {
			
			 String windowHandle = driver.getTitle();
			 System.out.println(windowHandle);
			 
			
			
			}
		public void screenShort(String filename) throws IOException {

			TakesScreenshot sc=(TakesScreenshot)driver;
			File src = sc.getScreenshotAs(OutputType.FILE);
			File des=new File("C:\\Users\\ELCOT\\eclipse-workspace\\Maven\\ScreenShot\\"+filename+".png");
			FileUtils.copyFile(src,des);
			
		}
		public static void Checkbox(WebElement element) {
			element.click();
			
		}
		public static void enable(WebElement element) {
			System.out.println(element.isEnabled());
		}
		public static void display(WebElement element) {
			element.isDisplayed();
		}
		public static void getUrl() {
			System.out.println(driver.getCurrentUrl());
		}
		public static void deselct(WebElement element, String value, String selectvalue) {
			Select s = new Select(element);
			
			if (selectvalue.equalsIgnoreCase("value")) {
				s.deselectByValue(value);
				
			}else if(selectvalue.equalsIgnoreCase("visible")) {
				s.deselectByVisibleText(value);
			}else if(selectvalue.equalsIgnoreCase("index")) {
			
				int index = Integer.parseInt(value);
				s.deselectByIndex(index);
			}
			else {
				System.out.println("Invalid deselect option");
			}

		}
		public void selectedoption(WebElement element) {
			Select s=new Select(element);
			java.util.List<WebElement> title = s.getAllSelectedOptions();
			for (WebElement webElement2 : title) {
				
		 
				
				System.out.println(webElement2);
			
			}
		}
		public void firstSelectOption(WebElement element) {
			Select s=new Select(element);
			System.out.println(s.getFirstSelectedOption());
			
		}
		public static  void implicitwait() {
			
			
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
				
			}
			
			
		public  static void explicitwait(WebElement element) {
			
			WebDriverWait w=new WebDriverWait(driver,30);
			w.until(ExpectedConditions.visibilityOf(element));
			
		}
		
//		public static void gettext(List element) {
//			
//			//for (WebElement text : element) {
//				String text2 = text.getText();
//				System.out.println(text2);
//				
//			}
//			}
		public static void getattribute(WebElement element,String value) {
			element.getAttribute(value);
			
		}
			
		
		public static void scroll(WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollintView();", element);
		}
		public static void sendkey(WebElement element,String text) {
			element.clear();
			element.sendKeys(text);
			
		}
		public static void clickelement(WebElement element) {
			element.click();
		}
		
		public static void radiobutton(WebElement element) {
			element.click();
			
		}
		
			}





