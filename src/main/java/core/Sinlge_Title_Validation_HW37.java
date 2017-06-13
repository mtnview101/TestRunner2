package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class Sinlge_Title_Validation_HW37 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
		
		String driverPath = ""; // project folder with browsers drivers
		driverPath =  "./src/main/resources/webdrivers/pc/MicrosoftWebDriver.exe";
		System.setProperty("webdriver.edge.driver", driverPath);
		WebDriver driver = new EdgeDriver(); 
		
/*		WebDriver driver = new HtmlUnitDriver(); 
		//((HtmlUnitDriver) driver).setJavascriptEnabled(true);
*/
		BufferedReader br = null;
		String line = null;
		br = new BufferedReader(new FileReader("./src/main/resources/Test.csv"));
		
		while ((line = br.readLine()) != null) {
			String[] csv = line.split(",");

			String text_case_id = csv[0];
			String url = csv[1];
			String title_expected = csv[2];
		
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		String title_actual = driver.getTitle();
		
		System.out.println();
		if (title_expected.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
			
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
		}

		}
		Thread.sleep(1000);
		driver.quit();
}}
