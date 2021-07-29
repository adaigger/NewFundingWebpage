package NewFundingPage;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
 
public class RollOverTests extends BaseTest {
    WebDriver driver;
 
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\devuser6\\Desktop\\geckodriver-v0.24.0-win32\\geckodriver.exe");
 
    }
 
 
    @BeforeMethod
	public void setUpMethod() throws Exception {
        System.out.println("--------Starting Test--------");
        driver = Utils.getDriver();
 
    }
 
    @AfterMethod
	public void tearDownMethod() throws Exception {
        System.out.println("--------Test Finished--------");
        driver.quit();
    }
 
 
     

 
public void LogoutCP() throws InterruptedException {
     
    driver.findElement(By.xpath("//*[@id=\"ib-bar-user-icon\"]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/button")).click();
    Thread.sleep(3000);
 
}

public void LogoutCPNeg() throws InterruptedException {
    
    driver.findElement(By.xpath("/html/body/am-header/div/nav[1]/div/div/ul[2]/li[3]/a/i")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/am-header/div/nav[1]/div/div/ul[2]/li[3]/div/div/div/div/am-button/a")).click();
    Thread.sleep(3000);
 
}
 
     
    
    public void RollOverSelection(String country) throws InterruptedException { 
    	 System.out.println("--------Opening New Funding Page--------");
         String homePage = "https://www.interactivebrokers.com/en/index.php?f=48276";  
         driver.get(homePage);  
         Thread.sleep(3000);
         Select TradeDropSearch = new Select(driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[1]/div/div/div[1]/am-select/select")));
         TradeDropSearch.selectByVisibleText("Roll Over/Transfer a Retirement Account");
         Thread.sleep(1000);
         Select CountryDropSearch = new Select(driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[1]/div/div/div[2]/am-country-select/am-select/select")));
         CountryDropSearch.selectByVisibleText(country);
        
         Thread.sleep(3000);
    }
    
    public boolean OptionsChecker(WebElement button, String type) throws InterruptedException { 
   	 System.out.println("--------Checking " + type+ " --------");
        button.click();
        Thread.sleep(1000);
        //click the Log In button in modal
        driver.findElement(By.xpath("/html/body/am-modal/div/div/div/div[3]/div/div[2]/div/p/am-button/a")).click();
        Thread.sleep(1000);
        return driver.getCurrentUrl().contains(type);
        
   }
    
    
    public boolean OptionsLoginValue2(WebElement button, String type, String user, String pass) throws InterruptedException { 
      	 System.out.println("--------Checking " + type+ " --------");
           button.click();
           Thread.sleep(1000);
           //click the Log In button in modal
           driver.findElement(By.xpath("/html/body/am-modal/div/div/div/div[3]/div/div[2]/div/p/am-button/a")).click();
           Thread.sleep(1000);
           
           driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys(user);
           driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
           driver.findElement(By.xpath("//*[@id=\"submitForm\"]")).click();
    
           Thread.sleep(8000);
           
           
           return driver.getCurrentUrl().contains(type);
           
      }
    
    public boolean OptionsLoginValue(WebElement button, String type, String user, String pass) throws InterruptedException { 
     	 System.out.println("--------Checking " + type+ " --------");
          button.click();
          Thread.sleep(1000);
          //click the Log In button in modal
          driver.findElement(By.xpath("/html/body/am-modal/div/div/div/div[3]/div/div[2]/div/p/am-button/a")).click();
          Thread.sleep(1000);
          
          driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys(user);
          driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
          driver.findElement(By.xpath("//*[@id=\"submitForm\"]")).click();
   
          Thread.sleep(8000);
          
          
          return Utils.getCPPositionsHeader(driver).getText().contains(type);
          
     }
    
    public boolean OptionsLoginValueNegative(WebElement button, String user, String pass) throws InterruptedException { 
     	 System.out.println("--------Checking for Negative Test --------");
          button.click();
          Thread.sleep(1000);
          //click the Log In button in modal
          driver.findElement(By.xpath("/html/body/am-modal/div/div/div/div[3]/div/div[2]/div/p/am-button/a")).click();
          Thread.sleep(1000);
          
          driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys(user);
          driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
          driver.findElement(By.xpath("//*[@id=\"submitForm\"]")).click();
   
          Thread.sleep(8000);
          
          return Utils.getNotAvailable(driver).getText().contains("Your account is not currently eligible for this feature");
         // return driver.getCurrentUrl().contains("Your account is not currently eligible for this feature.");
          
     }
 
    
    
    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
 
 
 
    @Test
    public void RollOver_CheckOptions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		RollOverSelection("United States");
        if(OptionsChecker(Utils.getRollChoice1(driver), "DIRECT_ROLLOVER_NOTIFICATION" ) == false){
            System.out.println("DIRECT_ROLLOVER_NOTIFICATION is missing");
            test.log(LogStatus.FAIL, "DIRECT_ROLLOVER_NOTIFICATION is missing");
        }
        else {
            //TWO
        	RollOverSelection("United States");
        	if(OptionsChecker(Utils.getRollChoice2(driver), "TRUSTEE_TO_TRUSTEE_NOTIFICATION" ) == false){
                System.out.println("TRUSTEE_TO_TRUSTEE_NOTIFICATION is missing");
                test.log(LogStatus.FAIL, "TRUSTEE_TO_TRUSTEE_NOTIFICATION is missing");
            }
        	else {
        		//THREE
        		RollOverSelection("Canada");
        		if(OptionsChecker(Utils.getRollChoiceSingle(driver), "ATON" ) == false){
                    System.out.println("ATON is missing");
                    test.log(LogStatus.FAIL, "ATON is missing");
                }
	                		else {
	                			//EXTRA
	                			RollOverSelection("United States");
	                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[3]/div/div/div/div/div[2]/p/am-button/a")) == true){
	                	            System.out.println("There is an extra method");
	                	            test.log(LogStatus.FAIL, "There is an extra method");
	                	        }
	                			else {
	                				//PASS
	                				System.out.println("All of the correct Methods are displayed");
	                	            test.log(LogStatus.PASS, "All of the correct Methods are displayed");
	                			}
                		}
            		}
        		}
        	}
    //fancy0008 for negative case
    @Test
    public void RollOver_DirectRollOver_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		RollOverSelection("United States");
		//Choose Method and login
		if(OptionsLoginValue(Utils.getRollChoice1(driver), "Direct Rollover Notification Deposit", "fancy0011", "tester12" ) == false){
            System.out.println("Direct Rollover Notification Deposit redirect is not working");
            test.log(LogStatus.FAIL, "Direct Rollover Notification Deposit redirect is not working");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("Direct Rollover Notification Deposit Redirect Worked Successfully");
            test.log(LogStatus.PASS, "Direct Rollover Notification Deposit Redirect Worked Successfully");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void RollOver_TrusteeToTrustee_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		RollOverSelection("United States");
		//Choose Method and login
		if(OptionsLoginValue(Utils.getRollChoice2(driver), "Trustee to Trustee Notification Deposit", "fancy0011", "tester12" ) == false){
            System.out.println("Trustee to Trustee redirect is not working");
            test.log(LogStatus.FAIL, "Trustee to Trustee redirect is not working");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("Trustee to Trustee Redirect Worked Successfully");
            test.log(LogStatus.PASS, "Trustee to Trustee Worked Successfully");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void RollOver_ATON_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		RollOverSelection("Canada");
		//Choose Method and login
		if(OptionsLoginValue(Utils.getRollChoiceSingle(driver), "ATON", "fancy0008", "tester12" ) == false){
            System.out.println("ATON redirect is not working");
            test.log(LogStatus.FAIL, "ATON redirect is not working");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("ATON Redirect Worked Successfully");
            test.log(LogStatus.PASS, "ATON Worked Successfully");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void RollOver_DirectRollOver_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		RollOverSelection("United States");
		//Choose Method and login
		if(OptionsLoginValueNegative(Utils.getRollChoice1(driver), "ajd060221", "Tester12" ) == false){
            System.out.println("DirectRollOver redirect incorrectly worked for an invalid account");
            test.log(LogStatus.FAIL, "DirectRollOver redirect incorrectly worked for an invalid account");
            Thread.sleep(3000);
            LogoutCPNeg();
        }
		else {
			//PASS
			System.out.println("DirectRollOver Redirect Successfully displayed error message for invalid account");
            test.log(LogStatus.PASS, "DirectRollOver Redirect Successfully displayed error message for invalid account");
            Thread.sleep(3000);
            LogoutCPNeg();
		}
		
    }
    
    @Test
    public void RollOver_TrusteeToTrustee_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		RollOverSelection("United States");
		//Choose Method and login
		if(OptionsLoginValueNegative(Utils.getRollChoice2(driver), "ajd060221", "Tester12" ) == false){
            System.out.println("TrusteeToTrustee redirect incorrectly worked for an invalid account");
            test.log(LogStatus.FAIL, "TrusteeToTrustee redirect incorrectly worked for an invalid account");
            Thread.sleep(3000);
            LogoutCPNeg();
        }
		else {
			//PASS
			System.out.println("TrusteeToTrustee Redirect Successfully displayed error message for invalid account");
            test.log(LogStatus.PASS, "TrusteeToTrustee Redirect Successfully displayed error message for invalid account");
            Thread.sleep(3000);
            LogoutCPNeg();
		}
		
    }
    
    @Test
    public void RollOver_ATON_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		RollOverSelection("Canada");
		//Choose Method and login
		if(OptionsLoginValueNegative(Utils.getRollChoiceSingle(driver), "ajd060221", "Tester12" ) == false){
            System.out.println("ATON redirect incorrectly worked for an invalid account");
            test.log(LogStatus.FAIL, "ATON redirect incorrectly worked for an invalid account");
            Thread.sleep(3000);
            LogoutCPNeg();
        }
		else {
			//PASS
			System.out.println("ATON Redirect Successfully displayed error message for invalid account");
            test.log(LogStatus.PASS, "ATON Redirect Successfully displayed error message for invalid account");
            Thread.sleep(3000);
            LogoutCPNeg();
		}
		
    }
        	
    
    @Test
    public void RollOver_DirectRollOver_Login_Invalid() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		RollOverSelection("United States");
		//Choose Method and login
		if(OptionsLoginValue(Utils.getRollChoice1(driver), "Deposit", "fancy0008", "tester12" ) == false){
            System.out.println("Direct Rollover Notification Deposit redirect is not working");
            test.log(LogStatus.FAIL, "Direct Rollover Notification Deposit redirect is not working");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("Direct Rollover Notification Deposit Redirect Worked Successfully");
            test.log(LogStatus.PASS, "Direct Rollover Notification Deposit Redirect Worked Successfully");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void RollOver_TrusteeToTrustee_Login_Invalid() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		RollOverSelection("United States");
		//Choose Method and login
		if(OptionsLoginValue(Utils.getRollChoice2(driver), "Deposit", "fancy0008", "tester12" ) == false){
            System.out.println("TrusteeToTrustee Notification Deposit redirect is not working");
            test.log(LogStatus.FAIL, "TrusteeToTrustee Notification Deposit redirect is not working");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("TrusteeToTrustee Notification Deposit Redirect Worked Successfully");
            test.log(LogStatus.PASS, "TrusteeToTrustee Notification Deposit Redirect Worked Successfully");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void RollOver_ATON_Login_Invalid() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		RollOverSelection("Canada");
		//Choose Method and login
		if(OptionsLoginValue(Utils.getRollChoiceSingle(driver), "Transfer Positions", "fancy0011", "tester12" ) == false){
            System.out.println("ATON Notification Deposit redirect is not working");
            test.log(LogStatus.FAIL, "ATON Notification Deposit redirect is not working");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("ATON Notification Deposit Redirect Worked Successfully");
            test.log(LogStatus.PASS, "ATON Notification Deposit Redirect Worked Successfully");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
        
 
    
    
}
