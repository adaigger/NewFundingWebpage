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
 
public class TransferPositionsTests extends BaseTest {
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
 
     
    
    public void PositionSelection() throws InterruptedException { 
    	 System.out.println("--------Opening New Funding Page--------");
         String homePage = "https://www.interactivebrokers.com/en/index.php?f=48276";  
         driver.get(homePage);  
         Thread.sleep(3000);
         Select CountryDropSearch = new Select(driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[1]/div/div/div[1]/am-select/select")));
         CountryDropSearch.selectByVisibleText("Transfer Positions");
        
         Thread.sleep(3000);
    }
    
    public boolean OptionsChecker(WebElement button, String type) throws InterruptedException { 
   	 System.out.println("--------Checking " + type+ " --------");
        button.click();
        Thread.sleep(1000);
        //click the Log In button in modal
        driver.findElement(By.xpath("/html/body/am-modal/div/div/div/div[3]/button-list/div/div[2]/div/p/am-button")).click();
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
          driver.findElement(By.xpath("/html/body/am-modal/div/div/div/div[3]/button-list/div/div[2]/div/p/am-button/a")).click();
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
 
    //***** Assumes user is already on the results table page *****
    public void ClientPortalLogin(String user, String pass) throws InterruptedException {
 
        // Click on new column
        driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div[1]/div/div[3]/div[2]/div[2]/table/tbody/tr[1]/td[1]")).click();
        Thread.sleep(1000);
        // Click on Login button
        driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div[2]/div/div/div/p[1]/button")).click();
        //Verify Login Page has loaded
        Thread.sleep(3000);
        //  String LoginURL = driver.getCurrentUrl();
        //   System.out.println(LoginURL);
 
        //Login into Client Portal
        driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys(user);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id=\"submitForm\"]")).click();
 
        Thread.sleep(3000);
 
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
    public void Positions_CheckOptions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		PositionSelection();
        if(OptionsChecker(Utils.getPosChoice1(driver), "ACATS" ) == false){
            System.out.println("ACATS is missing");
            test.log(LogStatus.FAIL, "ACATS is missing");
        }
        else {
            //TWO
        	PositionSelection();
        	if(OptionsChecker(Utils.getPosChoice2(driver), "ATON" ) == false){
                System.out.println("ATON is missing");
                test.log(LogStatus.FAIL, "ATON is missing");
            }
        	else {
        		//THREE
        		PositionSelection();
        		if(OptionsChecker(Utils.getPosChoice3(driver), "ASSET_TRANSFER" ) == false){
                    System.out.println("ASSET_TRANSFER is missing");
                    test.log(LogStatus.FAIL, "ASSET_TRANSFER is missing");
                }
        		else {
        			//FOUR
        			PositionSelection();
            		if(OptionsChecker(Utils.getPosChoice4(driver), "DRS" ) == false){
                        System.out.println("DRS is missing");
                        test.log(LogStatus.FAIL, "DRS is missing");
                    }
            		else {
            			//FIVE
            			PositionSelection();
                		if(OptionsChecker(Utils.getPosChoice5(driver), "DWAC" ) == false){
                            System.out.println("DWAC is missing");
                            test.log(LogStatus.FAIL, "DWAC is missing");
                        }else {
                			//SIX
                			PositionSelection();
                    		if(OptionsChecker(Utils.getPosChoice6(driver), "FOP" ) == false){
                                System.out.println("FOP is missing");
                                test.log(LogStatus.FAIL, "FOP is missing");
                            }
	                		else {
	                			//EXTRA
	                			PositionSelection();
	                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/div/div[7]/position-transfer-method-choice/div/div[3]/am-button/a")) == true){
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
        	}
        }
 
    }
    
    
    @Test
    public void Positions_ACATS_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValue(Utils.getPosChoice1(driver), "ACATS", "fancy0008", "tester12" ) == false){
            System.out.println("ACATS redirect is not working");
            test.log(LogStatus.FAIL, "ACATS redirect is not working");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("ACATS Redirect Worked Successfully");
            test.log(LogStatus.PASS, "ACATS Redirect Worked Successfully");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void Positions_ATON_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValue(Utils.getPosChoice2(driver), "ATON", "fancy0008", "tester12" ) == false){
            System.out.println("ATON redirect is not working");
            test.log(LogStatus.FAIL, "ATON redirect is not working");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("ATON Redirect Worked Successfully");
            test.log(LogStatus.PASS, "ATON Redirect Worked Successfully");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void Positions_BasicFOP_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValue(Utils.getPosChoice3(driver), "Basic FOP", "fancy0008", "tester12" ) == false){
            System.out.println("BasicFOP redirect is not working");
            test.log(LogStatus.FAIL, "BasicFOP redirect is not working");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("BasicFOP Redirect Worked Successfully");
            test.log(LogStatus.PASS, "BasicFOP Redirect Worked Successfully");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void Positions_DRS_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValue(Utils.getPosChoice4(driver), "DRS", "fancy0008", "tester12" ) == false){
            System.out.println("DRS redirect is not working");
            test.log(LogStatus.FAIL, "DRS redirect is not working");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("DRS Redirect Worked Successfully");
            test.log(LogStatus.PASS, "DRS Redirect Worked Successfully");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void Positions_DWAC_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValue(Utils.getPosChoice5(driver), "DWAC", "fancy0008", "tester12" ) == false){
            System.out.println("DWAC redirect is not working");
            test.log(LogStatus.FAIL, "DWAC redirect is not working");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("DWAC Redirect Worked Successfully");
            test.log(LogStatus.PASS, "DWAC Redirect Worked Successfully");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void Positions_FOP_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValue(Utils.getPosChoice6(driver), "FOP", "fancy0008", "tester12" ) == false){
            System.out.println("FOP redirect is not working");
            test.log(LogStatus.FAIL, "FOP redirect is not working");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("FOP Redirect Worked Successfully");
            test.log(LogStatus.PASS, "FOP Redirect Worked Successfully");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void Positions_ACATS_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValueNegative(Utils.getPosChoice1(driver), "ajd060221", "Tester12" ) == false){
            System.out.println("ACATS redirect incorrectly worked for an invalid account");
            test.log(LogStatus.FAIL, "ACATS redirect incorrectly worked for an invalid accoun");
            Thread.sleep(3000);
            LogoutCPNeg();
        }
		else {
			//PASS
			System.out.println("ACATS Redirect Successfully displayed error message for invalid account");
            test.log(LogStatus.PASS, "ACATS Redirect Successfully displayed error message for invalid account");
            Thread.sleep(3000);
            LogoutCPNeg();
		}
		
    }
    
    @Test
    public void Positions_ATON_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValueNegative(Utils.getPosChoice2(driver), "ajd060221", "Tester12" ) == false){
            System.out.println("ATON redirect incorrectly worked for an invalid account");
            test.log(LogStatus.FAIL, "ATON redirect incorrectly worked for an invalid accoun");
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
    public void Positions_BasicFOP_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValueNegative(Utils.getPosChoice3(driver), "ajd060221", "Tester12" ) == false){
            System.out.println("BasicFOP redirect incorrectly worked for an invalid account");
            test.log(LogStatus.FAIL, "BasicFOP redirect incorrectly worked for an invalid accoun");
            Thread.sleep(3000);
            LogoutCPNeg();
        }
		else {
			//PASS
			System.out.println("BasicFOP Redirect Successfully displayed error message for invalid account");
            test.log(LogStatus.PASS, "BasicFOP Redirect Successfully displayed error message for invalid account");
            Thread.sleep(3000);
            LogoutCPNeg();
		}
		
    }
    
    @Test
    public void Positions_DRS_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValueNegative(Utils.getPosChoice4(driver), "ajd060221", "Tester12" ) == false){
            System.out.println("DRS redirect incorrectly worked for an invalid account");
            test.log(LogStatus.FAIL, "DRS redirect incorrectly worked for an invalid accoun");
            Thread.sleep(3000);
            LogoutCPNeg();
        }
		else {
			//PASS
			System.out.println("DRS Redirect Successfully displayed error message for invalid account");
            test.log(LogStatus.PASS, "DRS Redirect Successfully displayed error message for invalid account");
            Thread.sleep(3000);
            LogoutCPNeg();
		}
		
    }
    
    @Test
    public void Positions_DWAC_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValueNegative(Utils.getPosChoice5(driver), "ajd060221", "Tester12" ) == false){
            System.out.println("DWAC redirect incorrectly worked for an invalid account");
            test.log(LogStatus.FAIL, "DWAC redirect incorrectly worked for an invalid accoun");
            Thread.sleep(3000);
            LogoutCPNeg();
        }
		else {
			//PASS
			System.out.println("DWAC Redirect Successfully displayed error message for invalid account");
            test.log(LogStatus.PASS, "DWAC Redirect Successfully displayed error message for invalid account");
            Thread.sleep(3000);
            LogoutCPNeg();
		}
		
    }
    
    @Test
    public void Positions_FOP_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValueNegative(Utils.getPosChoice6(driver), "ajd060221", "Tester12" ) == false){
            System.out.println("FOP redirect incorrectly worked for an invalid account");
            test.log(LogStatus.FAIL, "FOP redirect incorrectly worked for an invalid accoun");
            Thread.sleep(3000);
            LogoutCPNeg();
        }
		else {
			//PASS
			System.out.println("FOP Redirect Successfully displayed error message for invalid account");
            test.log(LogStatus.PASS, "FOP Redirect Successfully displayed error message for invalid account");
            Thread.sleep(3000);
            LogoutCPNeg();
		}
		
    }
    // Choosing an option that your account is qualified for. Verifies that user is brought to the high level Positions Transfer page, and not the method they cannot use
    @Test
    public void Positions_ATON_Login_Invalid() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValue(Utils.getPosChoice2(driver), "Transfer Positions", "fancy0011", "tester12" ) == false){
            System.out.println("ATON redirect Allowed an invalid account");
            test.log(LogStatus.FAIL, "ATON redirect Allowed an invalid account");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("ATON redirect correctly brought invalid account to top level page");
            test.log(LogStatus.PASS, "ATON redirect correctly brought invalid account to top level page");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void Positions_BasicFOP_Login_Invalid() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValue(Utils.getPosChoice3(driver), "Transfer Positions", "fancy0011", "tester12" ) == false){
            System.out.println("ATON redirect Allowed an invalid account");
            test.log(LogStatus.FAIL, "ATON redirect Allowed an invalid account");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("ATON redirect correctly brought invalid account to top level page");
            test.log(LogStatus.PASS, "ATON redirect correctly brought invalid account to top level page");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void Positions_DRS_Login_Invalid() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValue(Utils.getPosChoice4(driver), "Transfer Positions", "fancy0011", "tester12" ) == false){
            System.out.println("ATON redirect Allowed an invalid account");
            test.log(LogStatus.FAIL, "ATON redirect Allowed an invalid account");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("ATON redirect correctly brought invalid account to top level page");
            test.log(LogStatus.PASS, "ATON redirect correctly brought invalid account to top level page");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void Positions_DWAC_Login_Invalid() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValue(Utils.getPosChoice5(driver), "Transfer Positions", "fancy0011", "tester12" ) == false){
            System.out.println("ATON redirect Allowed an invalid account");
            test.log(LogStatus.FAIL, "ATON redirect Allowed an invalid account");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("ATON redirect correctly brought invalid account to top level page");
            test.log(LogStatus.PASS, "ATON redirect correctly brought invalid account to top level page");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    @Test
    public void Positions_FOP_Login_Invalid() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Select the Positions dropdown
		PositionSelection();
		//Choose Method and login
		if(OptionsLoginValue(Utils.getPosChoice6(driver), "Transfer Positions", "fancy0011", "tester12" ) == false){
            System.out.println("FOP redirect Allowed an invalid account");
            test.log(LogStatus.FAIL, "FOP redirect Allowed an invalid account");
            Thread.sleep(3000);
            LogoutCP();
        }
		else {
			//PASS
			System.out.println("FOP redirect correctly brought invalid account to top level page");
            test.log(LogStatus.PASS, "FOP redirect correctly brought invalid account to top level page");
            Thread.sleep(3000);
            LogoutCP();
		}
		
    }
    
    
    
    
    
}
