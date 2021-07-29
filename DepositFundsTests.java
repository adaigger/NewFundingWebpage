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
 
public class DepositFundsTests extends BaseTest {
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
 
     
     
     
     
     
    public WebElement GetViewResultsButton() {
         
        return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/form/div[7]/div/button[1]"));
     
    }
     

 
public void LogoutCP() throws InterruptedException {
     
    driver.findElement(By.xpath("//*[@id=\"ib-bar-user-icon\"]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/button")).click();
    Thread.sleep(3000);
 
}

public void LogoutCPAlt() throws InterruptedException {
    
    driver.findElement(By.xpath("/html/body/am-header/div/nav[1]/div/div/ul[2]/li[3]/a/i")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/am-header/div/nav[1]/div/div/ul[2]/li[3]/div/div/div/div/am-button/a")).click();
    Thread.sleep(3000);
 
}
 
     
    
    public void DepositSelection(String country, String currency) throws InterruptedException { 
    	 System.out.println("--------Opening New Funding Page--------");
         String homePage = "https://www.interactivebrokers.com/en/index.php?f=48276";  
         driver.get(homePage);  
         Thread.sleep(3000);
         Select CountryDropSearch = new Select(driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[1]/div/div/div[2]/am-country-select/am-select/select")));
         CountryDropSearch.selectByVisibleText(country);
         Thread.sleep(1000);
         Select CurrencyDropSearch = new Select(driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[1]/div/div/div[3]/am-select/select")));
         CurrencyDropSearch.selectByVisibleText(currency);
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
    // Used for certain accounts who have a different header xpath
    public boolean OptionsLoginValueAlt(WebElement button, String type, String user, String pass) throws InterruptedException { 
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
        
        
        return Utils.getCPPositionsHeaderAlt(driver).getText().contains(type);
        
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
    public void Deposit_USA_USD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "United States Dollar (USD)");
        if(OptionsChecker(Utils.getChoice1(driver), "DIRECT_DEPOSIT" ) == false){
            System.out.println("Direct Deposit is missing");
            test.log(LogStatus.FAIL, "Direct Deposit is missing");
        }
        else {
            //TWO
        	DepositSelection("United States", "United States Dollar (USD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "ACH" ) == false){
                System.out.println("ACH is missing");
                test.log(LogStatus.FAIL, "ACH is missing");
            }
        	else {
        		//THREE
        		DepositSelection("United States", "United States Dollar (USD)");
        		if(OptionsChecker(Utils.getChoice3(driver), "WIRE_NOTIFICATION" ) == false){
                    System.out.println("Bank Wire is missing");
                    test.log(LogStatus.FAIL, "Bank Wire is missing");
                }
        		else {
        			//FOUR
        			DepositSelection("United States", "United States Dollar (USD)");
            		if(OptionsChecker(Utils.getChoice4(driver), "BILL_PAY_NOTIFICATION" ) == false){
                        System.out.println("Bill Pay is missing");
                        test.log(LogStatus.FAIL, "Bill Pay is missing");
                    }
            		else {
            			//FIVE
            			DepositSelection("United States", "United States Dollar (USD)");
                		if(OptionsChecker(Utils.getChoice5(driver), "CHECK_NOTIFICATION" ) == false){
                            System.out.println("Mail a Check is missing");
                            test.log(LogStatus.FAIL, "Mail a Check is missing");
                        }
                		else {
                			//EXTRA
                			DepositSelection("United States", "United States Dollar (USD)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[6]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_USA_AUD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Search for the Deposit Combo
		DepositSelection("United States", "Australian Dollar (AUD)");
		
        //check that Direct Deposit is displayed
        if(OptionsChecker(Utils.getChoice1(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("E Funds Trasnfer is missing");
            test.log(LogStatus.FAIL, "E Funds Transfer is missing");
        }
        else {
        	DepositSelection("United States", "Australian Dollar (AUD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "BPAY_NOTIFICATION" ) == false){
                System.out.println("BPAY_NOTIFICATION is missing");
                test.log(LogStatus.FAIL, "BPAY_NOTIFICATION is missing");
            }
        	else {
        		DepositSelection("United States", "Australian Dollar (AUD)");
    			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[3]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
    	            System.out.println("There is an extra method");
    	            test.log(LogStatus.FAIL, "There is an extra method");
    	        }
    			else {
    				System.out.println("All of the correct Methods are displayed");
    	            test.log(LogStatus.PASS, "All of the correct Methods are displayed");
    			}
             
        }
 
    }
    
    }
    
    @Test
    public void Deposit_USA_GBP() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//Search for the Deposit Combo
		DepositSelection("United States", "British Pound (GBP)");
		
        //check that Direct Deposit is displayed
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	DepositSelection("United States", "British Pound (GBP)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
	            System.out.println("There is an extra method");
	            test.log(LogStatus.FAIL, "There is an extra method");
	        }
			else {
				System.out.println("All of the correct Methods are displayed");
	            test.log(LogStatus.PASS, "All of the correct Methods are displayed");
			}
        }
    }
    
    @Test
    public void Deposit_UK_USD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United Kingdom", "United States Dollar (USD)");
        if(OptionsChecker(Utils.getChoice1(driver), "ACH" ) == false){
            System.out.println("ACH is missing");
            test.log(LogStatus.FAIL, "ACH is missing");
        }
        else {
            //TWO
        	DepositSelection("United Kingdom", "United States Dollar (USD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "WIRE_NOTIFICATION" ) == false){
                System.out.println("WIRE_NOTIFICATION is missing");
                test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
            }
        	else {
        		//THREE
        		DepositSelection("United Kingdom", "United States Dollar (USD)");
        		if(OptionsChecker(Utils.getChoice3(driver), "BILL_PAY_NOTIFICATION" ) == false){
                    System.out.println("BILL_PAY_NOTIFICATION is missing");
                    test.log(LogStatus.FAIL, "BILL_PAY_NOTIFICATION is missing");
                }
        		else {
        			//FOUR
        			DepositSelection("United Kingdom", "United States Dollar (USD)");
            		if(OptionsChecker(Utils.getChoice4(driver), "CHECK_NOTIFICATION" ) == false){
                        System.out.println("CHECK_NOTIFICATION is missing");
                        test.log(LogStatus.FAIL, "CHECK_NOTIFICATION is missing");
                    }           		
                		else {
                			//EXTRA
                			DepositSelection("United Kingdom", "United States Dollar (USD)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[5]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_UK_GBP() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United Kingdom", "British Pound (GBP)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	//EXTRA
        	DepositSelection("United Kingdom", "British Pound (GBP)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_UK_AUD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United Kingdom", "Australian Dollar (AUD)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("WIRE_NOTIFICATION is missing");
            test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
        }
	        else {
	            //TWO
	        	DepositSelection("United Kingdom", "Australian Dollar (AUD)");
	        	if(OptionsChecker(Utils.getChoice2(driver), "BPAY_NOTIFICATION" ) == false){
	                System.out.println("BPAY_NOTIFICATION is missing");
	                test.log(LogStatus.FAIL, "BPAY_NOTIFICATION is missing");
	            }
		        else {
		        	//EXTRA
		        	DepositSelection("United Kingdom", "Australian Dollar (AUD)");
					if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[3]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_CAN_CAD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Canada", "Canadian Dollar (CAD)");
        if(OptionsChecker(Utils.getChoice1(driver), "EFT" ) == false){
            System.out.println("EFT is missing");
            test.log(LogStatus.FAIL, "EFT is missing");
        }
        else {
            //TWO
        	DepositSelection("Canada", "Canadian Dollar (CAD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "WIRE_NOTIFICATION" ) == false){
                System.out.println("WIRE_NOTIFICATION is missing");
                test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
            }
        	else {
        		//THREE
        		DepositSelection("Canada", "Canadian Dollar (CAD)");
        		if(OptionsChecker(Utils.getChoice3(driver), "BILL_PAY_NOTIFICATION" ) == false){
                    System.out.println("BILL_PAY_NOTIFICATION is missing");
                    test.log(LogStatus.FAIL, "BILL_PAY_NOTIFICATION is missing");
                }		
                		else {
                			//EXTRA
                			DepositSelection("Canada", "Canadian Dollar (CAD)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[4]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_CAN_USD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Canada", "United States Dollar (USD)");
        if(OptionsChecker(Utils.getChoice1(driver), "EFT" ) == false){
            System.out.println("EFT is missing");
            test.log(LogStatus.FAIL, "EFT is missing");
        }
        else {
            //TWO
        	DepositSelection("Canada", "United States Dollar (USD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "WIRE_NOTIFICATION" ) == false){
                System.out.println("WIRE_NOTIFICATION is missing");
                test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
            }
        	else {
        		//THREE
        		DepositSelection("Canada", "United States Dollar (USD)");
        		if(OptionsChecker(Utils.getChoice3(driver), "BILL_PAY_NOTIFICATION" ) == false){
                    System.out.println("BILL_PAY_NOTIFICATION is missing");
                    test.log(LogStatus.FAIL, "BILL_PAY_NOTIFICATION is missing");
                }		
                		else {
                			//EXTRA
                			DepositSelection("Canada", "United States Dollar (USD)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[4]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_CAN_AUD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Canada", "Australian Dollar (AUD)");
        if(OptionsChecker(Utils.getChoice1(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("WIRE_NOTIFICATION is missing");
            test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
        }
        else {
            //TWO
        	DepositSelection("Canada", "Australian Dollar (AUD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "BPAY_NOTIFICATION" ) == false){
                System.out.println("BPAY_NOTIFICATION is missing");
                test.log(LogStatus.FAIL, "BPAY_NOTIFICATION is missing");
            }
                		else {
                			//EXTRA
                			DepositSelection("Canada", "Australian Dollar (AUD)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[3]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_HK_HKD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Hong Kong Special Administrative Region of China", "Hong Kong Dollar (HKD)");
        if(OptionsChecker(Utils.getChoice1(driver), "FPS_NOTIFICATION" ) == false){
            System.out.println("FPS_NOTIFICATION is missing");
            test.log(LogStatus.FAIL, "FPS_NOTIFICATION is missing");
        }
        else {
            //TWO
        	DepositSelection("Hong Kong Special Administrative Region of China", "Hong Kong Dollar (HKD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "WIRE_NOTIFICATION" ) == false){
                System.out.println("WIRE_NOTIFICATION is missing");
                test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
            }
        	else {
        		//THREE
        		DepositSelection("Hong Kong Special Administrative Region of China", "Hong Kong Dollar (HKD)");
        		if(OptionsChecker(Utils.getChoice3(driver), "CHECK_NOTIFICATION" ) == false){
                    System.out.println("CHECK_NOTIFICATION is missing");
                    test.log(LogStatus.FAIL, "CHECK_NOTIFICATION is missing");
                }		
                		else {
                			//EXTRA
                			DepositSelection("Hong Kong Special Administrative Region of China", "Hong Kong Dollar (HKD)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[4]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_HK_USD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Hong Kong Special Administrative Region of China", "United States Dollar (USD)");
        if(OptionsChecker(Utils.getChoice1(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("WIRE_NOTIFICATION is missing");
            test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
        }
        else {
            //TWO
        	DepositSelection("Hong Kong Special Administrative Region of China", "United States Dollar (USD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "ACH" ) == false){
                System.out.println("ACH is missing");
                test.log(LogStatus.FAIL, "ACH is missing");
            }
        	else {
        		//THREE
        		DepositSelection("Hong Kong Special Administrative Region of China", "United States Dollar (USD)");
        		if(OptionsChecker(Utils.getChoice3(driver), "BILL_PAY_NOTIFICATION" ) == false){
                    System.out.println("BILL_PAY_NOTIFICATION is missing");
                    test.log(LogStatus.FAIL, "BILL_PAY_NOTIFICATION is missing");
                }		
                		else {
                			//EXTRA
                			DepositSelection("Hong Kong Special Administrative Region of China", "United States Dollar (USD)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[4]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_HK_AUD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Hong Kong Special Administrative Region of China", "Australian Dollar (AUD)");
        if(OptionsChecker(Utils.getChoice1(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("WIRE_NOTIFICATION is missing");
            test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
        }
        else {
            //TWO
        	DepositSelection("Hong Kong Special Administrative Region of China", "Australian Dollar (AUD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "BPAY_NOTIFICATION" ) == false){
                System.out.println("BPAY_NOTIFICATION is missing");
                test.log(LogStatus.FAIL, "BPAY_NOTIFICATION is missing");
            }       	
                		else {
                			//EXTRA
                			DepositSelection("Hong Kong Special Administrative Region of China", "Australian Dollar (AUD)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[3]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_AUS_AUD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Australia", "Australian Dollar (AUD)");
        if(OptionsChecker(Utils.getChoice1(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("WIRE_NOTIFICATION is missing");
            test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
        }
        else {
            //TWO
        	DepositSelection("Australia", "Australian Dollar (AUD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "BPAY_NOTIFICATION" ) == false){
                System.out.println("BPAY_NOTIFICATION is missing");
                test.log(LogStatus.FAIL, "BPAY_NOTIFICATION is missing");
            }       	
                		else {
                			//EXTRA
                			DepositSelection("Australia", "Australian Dollar (AUD)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[3]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    
    @Test
    public void Deposit_AUS_USD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Australia", "United States Dollar (USD)");
        if(OptionsChecker(Utils.getChoice1(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("WIRE_NOTIFICATION is missing");
            test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
        }
        else {
            //TWO
        	DepositSelection("Australia", "United States Dollar (USD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "ACH" ) == false){
                System.out.println("ACH is missing");
                test.log(LogStatus.FAIL, "ACH is missing");
            }
        	else {
        		//THREE
        		DepositSelection("Australia", "United States Dollar (USD)");
        		if(OptionsChecker(Utils.getChoice3(driver), "BILL_PAY_NOTIFICATION" ) == false){
                    System.out.println("BILL_PAY_NOTIFICATION is missing");
                    test.log(LogStatus.FAIL, "BILL_PAY_NOTIFICATION is missing");
                }		
                		else {
                			//EXTRA
                			DepositSelection("Australia", "United States Dollar (USD)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[4]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_AUS_EUR() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Australia", "Euro (EUR)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	//EXTRA
        	DepositSelection("Australia", "Euro (EUR)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_AUS_GBP() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Australia", "British Pound (GBP)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	//EXTRA
        	DepositSelection("Australia", "British Pound (GBP)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_DUE_USD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Germany", "United States Dollar (USD)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	//EXTRA
        	DepositSelection("Germany", "United States Dollar (USD)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_DUE_GBP() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Germany", "British Pound (GBP)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	//EXTRA
        	DepositSelection("Germany", "British Pound (GBP)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_DUE_EUR() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Germany", "Euro (EUR)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	//EXTRA
        	DepositSelection("Germany", "Euro (EUR)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_JPN_JPY() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Japan", "Japanese Yen (JPY)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	//EXTRA
        	DepositSelection("Japan", "Japanese Yen (JPY)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_SGP_USD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Singapore", "United States Dollar (USD)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	//EXTRA
        	DepositSelection("Singapore", "United States Dollar (USD)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_SGP_SGD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Singapore", "Singapore Dollar (SGD)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	//EXTRA
        	DepositSelection("Singapore", "Singapore Dollar (SGD)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_SGP_GBP() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Singapore", "British Pound (GBP)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	//EXTRA
        	DepositSelection("Singapore", "British Pound (GBP)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_SGP_CNH() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Singapore", "Chinese Offshore Yuan (CNH)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	//EXTRA
        	DepositSelection("Singapore", "Chinese Offshore Yuan (CNH)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_SGP_HKD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Singapore", "Hong Kong Dollar (HKD)");
        if(OptionsChecker(Utils.getChoiceSingle(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("Bank Wire is missing");
            test.log(LogStatus.FAIL, "Bank Wire is missing");
        }
        else {
        	//EXTRA
        	DepositSelection("Singapore", "Hong Kong Dollar (HKD)");
			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_IND_INR() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("India", "Indian Rupee (INR)");
        if(OptionsChecker(Utils.getChoice1(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("WIRE_NOTIFICATION is missing");
            test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
        }
        else {
            //TWO
        	DepositSelection("India", "Indian Rupee (INR)");
        	if(OptionsChecker(Utils.getChoice2(driver), "CHECK_NOTIFICATION" ) == false){
                System.out.println("CHECK_NOTIFICATION is missing");
                test.log(LogStatus.FAIL, "CHECK_NOTIFICATION is missing");
            }       	
                		else {
                			//EXTRA
                			DepositSelection("India", "Indian Rupee (INR)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[3]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    
    @Test
    public void Deposit_CHN_USD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("China", "United States Dollar (USD)");
        if(OptionsChecker(Utils.getChoice1(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("WIRE_NOTIFICATION is missing");
            test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
        }
        else {
            //TWO
        	DepositSelection("China", "United States Dollar (USD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "DIRECT_DEPOSIT" ) == false){
                System.out.println("DIRECT_DEPOSIT is missing");
                test.log(LogStatus.FAIL, "DIRECT_DEPOSIT is missing");
            }
        	else {
        		//THREE
        		DepositSelection("China", "United States Dollar (USD)");
        		if(OptionsChecker(Utils.getChoice3(driver), "ACH" ) == false){
                    System.out.println("ACH is missing");
                    test.log(LogStatus.FAIL, "ACH is missing");
                }
        		else {
        			//FOUR
        			DepositSelection("China", "United States Dollar (USD)");
            		if(OptionsChecker(Utils.getChoice4(driver), "BILL_PAY_NOTIFICATION" ) == false){
                        System.out.println("Bill Pay is missing");
                        test.log(LogStatus.FAIL, "Bill Pay is missing");
                    }
            		else {
            			//FIVE
            			DepositSelection("China", "United States Dollar (USD)");
                		if(OptionsChecker(Utils.getChoice5(driver), "CHECK_NOTIFICATION" ) == false){
                            System.out.println("Mail a Check is missing");
                            test.log(LogStatus.FAIL, "Mail a Check is missing");
                        }
                		else {
                			//EXTRA
                			DepositSelection("China", "United States Dollar (USD)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[6]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
                	            System.out.println("There is an extra method");
                	            test.log(LogStatus.FAIL, "There is an extra method");
                	        }
                			else {
                				System.out.println("All of the correct Methods are displayed");
                	            test.log(LogStatus.PASS, "All of the correct Methods are displayed");
                			}
                		}
            		}
        		}
        	}
             
        }
 
    }
    
    @Test
    public void Deposit_CHN_CNH() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("China", "Chinese Offshore Yuan (CNH)");
        if(OptionsChecker(Utils.getChoice1(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("WIRE_NOTIFICATION is missing");
            test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
        }
        else {
            //TWO
        	DepositSelection("China", "Chinese Offshore Yuan (CNH)");
        	if(OptionsChecker(Utils.getChoice2(driver), "FPS_NOTIFICATION" ) == false){
                System.out.println("FPS_NOTIFICATION is missing");
                test.log(LogStatus.FAIL, "FPS_NOTIFICATION is missing");
            }
                		else {
                			//EXTRA
                			DepositSelection("China", "Chinese Offshore Yuan (CNH)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[3]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_CNH_HKD() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("China", "Hong Kong Dollar (HKD)");
        if(OptionsChecker(Utils.getChoice1(driver), "WIRE_NOTIFICATION" ) == false){
            System.out.println("WIRE_NOTIFICATION is missing");
            test.log(LogStatus.FAIL, "WIRE_NOTIFICATION is missing");
        }
        else {
            //TWO
        	DepositSelection("China", "Hong Kong Dollar (HKD)");
        	if(OptionsChecker(Utils.getChoice2(driver), "CCB_FUNDS_TRANSFER_NOTIFICATION" ) == false){
                System.out.println("CCB_FUNDS_TRANSFER_NOTIFICATION is missing");
                test.log(LogStatus.FAIL, "CCB_FUNDS_TRANSFER_NOTIFICATION is missing");
            }
        	else {
        		//THREE
        		DepositSelection("China", "Hong Kong Dollar (HKD)");
        		if(OptionsChecker(Utils.getChoice3(driver), "CHECK_NOTIFICATION" ) == false){
                    System.out.println("CHECK_NOTIFICATION is missing");
                    test.log(LogStatus.FAIL, "CHECK_NOTIFICATION is missing");
                }
        		else {
        			//FOUR
        			DepositSelection("China", "Hong Kong Dollar (HKD)");
            		if(OptionsChecker(Utils.getChoice4(driver), "FPS_NOTIFICATION" ) == false){
                        System.out.println("FPS_NOTIFICATION is missing");
                        test.log(LogStatus.FAIL, "FPS_NOTIFICATION is missing");
                    }           		
                		else {
                			//EXTRA
                			DepositSelection("China", "Hong Kong Dollar (HKD)");
                			if(isElementPresent(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[5]/div/div[1]/div/div/div[2]/p/am-button/a")) == true){
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
    
    @Test
    public void Deposit_DirectDeposit_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "United States Dollar (USD)");
		//Choose Method and login
				if(OptionsLoginValue(Utils.getChoice1(driver), "Electronic / Direct Transfer Deposit", "fancy0008", "tester12" ) == false){
		            System.out.println("Direct Deposit redirect is not working");
		            test.log(LogStatus.FAIL, "Direct Deposit redirect is not working");
		            Thread.sleep(3000);
		            LogoutCP();
		        }
				else {
					//PASS
					System.out.println("Direct Deposit Redirect Worked Successfully");
		            test.log(LogStatus.PASS, "Direct Deposit Redirect Worked Successfully");
		            Thread.sleep(3000);
		            LogoutCP();
				}
				
		    }
    
    @Test
    public void Deposit_EFundTransfer_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "Australian Dollar (AUD)");
		//Choose Method and login
				if(OptionsLoginValue(Utils.getChoice1(driver), "Electronic Funds Transfer Deposit", "fancy0008", "tester12" ) == false){
		            System.out.println("Electronic Funds Transfer Deposit redirect is not working");
		            test.log(LogStatus.FAIL, "Electronic Funds Transfer Deposit redirect is not working");
		            Thread.sleep(3000);
		            LogoutCP();
		        }
				else {
					//PASS
					System.out.println("Electronic Funds Transfer Deposit Redirect Worked Successfully");
		            test.log(LogStatus.PASS, "Electronic Funds Transfer Deposit Redirect Worked Successfully");
		            Thread.sleep(3000);
		            LogoutCP();
				}
				
		    }
    
    @Test
    public void Deposit_ACH_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "United States Dollar (USD)");
		//Choose Method and login
				if(OptionsLoginValue(Utils.getChoice2(driver), "Connect Your Bank via ACH Deposit", "fancy0008", "tester12" ) == false){
		            System.out.println("ACH Deposit redirect is not working");
		            test.log(LogStatus.FAIL, "ACH Deposit redirect is not working");
		            Thread.sleep(3000);
		            LogoutCP();
		        }
				else {
					//PASS
					System.out.println("ACH Deposit Redirect Worked Successfully");
		            test.log(LogStatus.PASS, "ACH Deposit Redirect Worked Successfully");
		            Thread.sleep(3000);
		            LogoutCP();
				}
				
		    }
    
    @Test
    public void Deposit_BankWire_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "United States Dollar (USD)");
		//Choose Method and login
				if(OptionsLoginValue(Utils.getChoice3(driver), "Bank Wire Deposit", "fancy0008", "tester12" ) == false){
		            System.out.println("Bank Wire Deposit redirect is not working");
		            test.log(LogStatus.FAIL, "Bank Wire redirect is not working");
		            Thread.sleep(3000);
		            LogoutCP();
		        }
				else {
					//PASS
					System.out.println("Bank Wire Deposit Redirect Worked Successfully");
		            test.log(LogStatus.PASS, "Bank Wire Deposit Redirect Worked Successfully");
		            Thread.sleep(3000);
		            LogoutCP();
				}
				
		    }
    
    @Test
    public void Deposit_BillPay_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "United States Dollar (USD)");
		//Choose Method and login
				if(OptionsLoginValue(Utils.getChoice4(driver), "Online Bill Pay Deposit", "fancy0008", "tester12" ) == false){
		            System.out.println("Bill Pay Deposit redirect is not working");
		            test.log(LogStatus.FAIL, "Bill Pay redirect is not working");
		            Thread.sleep(3000);
		            LogoutCP();
		        }
				else {
					//PASS
					System.out.println("Bill Pay Deposit Redirect Worked Successfully");
		            test.log(LogStatus.PASS, "Bill Pay Deposit Redirect Worked Successfully");
		            Thread.sleep(3000);
		            LogoutCP();
				}
				
		    }
    
    @Test
    public void Deposit_MailACheck_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "United States Dollar (USD)");
		//Choose Method and login
				if(OptionsLoginValue(Utils.getChoice5(driver), "Mail a Check Deposit", "fancy0008", "tester12" ) == false){
		            System.out.println("Mail a Check Deposit redirect is not working");
		            test.log(LogStatus.FAIL, "Mail a Check redirect is not working");
		            Thread.sleep(3000);
		            LogoutCP();
		        }
				else {
					//PASS
					System.out.println("Mail a Check Deposit Redirect Worked Successfully");
		            test.log(LogStatus.PASS, "Mail a Check Deposit Redirect Worked Successfully");
		            Thread.sleep(3000);
		            LogoutCP();
				}
				
		    }
    // Need to find a valid Can CAD account on Prod
    @Test
    public void Deposit_EFT_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Canada", "Canadian Dollar (CAD)");
		//Choose Method and login
				if(OptionsLoginValue(Utils.getChoice1(driver), "Connect Your Bank via EFT Deposit", "fdcan514", "canada22" ) == false){
		            System.out.println("EFT Deposit redirect is not working");
		            test.log(LogStatus.FAIL, "EFT redirect is not working");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("EFT Deposit Redirect Worked Successfully");
		            test.log(LogStatus.PASS, "EFT Deposit Redirect Worked Successfully");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_Zengin_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Japan", "Japanese Yen (JPY)");
		//Choose Method and login
				if(OptionsLoginValueAlt(Utils.getChoiceSingle(driver), "Bank Wire Deposit", "fancy1005", "tester12" ) == false){
		            System.out.println("Zengin Deposit redirect is not working");
		            test.log(LogStatus.FAIL, "Zengin redirect is not working");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("Zengin Deposit Redirect Worked Successfully");
		            test.log(LogStatus.PASS, "Zengin Deposit Redirect Worked Successfully");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_BPay_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "Australian Dollar (AUD)");
		//Choose Method and login
				if(OptionsLoginValueAlt(Utils.getChoice2(driver), "Online BPAY Deposit", "fancy1005", "tester12" ) == false){
		            System.out.println("BPay Deposit redirect is not working");
		            test.log(LogStatus.FAIL, "BPay redirect is not working");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("BPay Deposit Redirect Worked Successfully");
		            test.log(LogStatus.PASS, "BPay Deposit Redirect Worked Successfully");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_FPS_Login() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Hong Kong Special Administrative Region of China", "Hong Kong Dollar (HKD)");
		//Choose Method and login
				if(OptionsLoginValueAlt(Utils.getChoice1(driver), "Instant Local Transfer via FPS Deposit", "fancy1003", "tester12" ) == false){
		            System.out.println("FPS Deposit redirect is not working");
		            test.log(LogStatus.FAIL, "FPS redirect is not working");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("FPS Deposit Redirect Worked Successfully");
		            test.log(LogStatus.PASS, "FPS Deposit Redirect Worked Successfully");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_DirectDeposit_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "United States Dollar (USD)");
		//Choose Method and login
				if(OptionsLoginValueNegative(Utils.getChoice1(driver), "ajd060221", "Tester12" ) == false){
		            System.out.println("Direct Deposit redirect incorrectly worked for an Invalid account");
		            test.log(LogStatus.FAIL, "Direct Deposit redirect incorrectly worked for an Invalid account");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("Direct Deposit redirect displayed correct message for an Invalid account");
		            test.log(LogStatus.PASS, "Direct Deposit Redirect displayed correct message");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_EFundTransfer_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "Australian Dollar (AUD)");
		//Choose Method and login
				if(OptionsLoginValueNegative(Utils.getChoice1(driver), "ajd060221", "Tester12" ) == false){
		            System.out.println("EFundTransfer redirect incorrectly worked for an Invalid account");
		            test.log(LogStatus.FAIL, "EFundTransfer redirect incorrectly worked for an Invalid account");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("EFundTransfer redirect displayed correct message for an Invalid account");
		            test.log(LogStatus.PASS, "EFundTransfer Redirect displayed correct message");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_ACH_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "United States Dollar (USD)");
		//Choose Method and login
				if(OptionsLoginValueNegative(Utils.getChoice2(driver), "ajd060221", "Tester12" ) == false){
		            System.out.println("ACH redirect incorrectly worked for an Invalid account");
		            test.log(LogStatus.FAIL, "ACH redirect incorrectly worked for an Invalid account");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("ACH redirect displayed correct message for an Invalid account");
		            test.log(LogStatus.PASS, "ACH Redirect displayed correct message");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_BankWire_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "United States Dollar (USD)");
		//Choose Method and login
				if(OptionsLoginValueNegative(Utils.getChoice3(driver), "ajd060221", "Tester12" ) == false){
		            System.out.println("BankWire redirect incorrectly worked for an Invalid account");
		            test.log(LogStatus.FAIL, "BankWire redirect incorrectly worked for an Invalid account");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("BankWire redirect displayed correct message for an Invalid account");
		            test.log(LogStatus.PASS, "BankWire Redirect displayed correct message");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_BillPay_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "United States Dollar (USD)");
		//Choose Method and login
				if(OptionsLoginValueNegative(Utils.getChoice4(driver), "ajd060221", "Tester12" ) == false){
		            System.out.println("BillPay redirect incorrectly worked for an Invalid account");
		            test.log(LogStatus.FAIL, "BillPay redirect incorrectly worked for an Invalid account");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("BillPay redirect displayed correct message for an Invalid account");
		            test.log(LogStatus.PASS, "BillPay Redirect displayed correct message");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_MailACheck_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "United States Dollar (USD)");
		//Choose Method and login
				if(OptionsLoginValueNegative(Utils.getChoice5(driver), "ajd060221", "Tester12" ) == false){
		            System.out.println("MailACheck redirect incorrectly worked for an Invalid account");
		            test.log(LogStatus.FAIL, "MailACheck redirect incorrectly worked for an Invalid account");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("MailACheck redirect displayed correct message for an Invalid account");
		            test.log(LogStatus.PASS, "MailACheck Redirect displayed correct message");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_EFT_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Canada", "Canadian Dollar (CAD)");
		//Choose Method and login
				if(OptionsLoginValueNegative(Utils.getChoice1(driver), "ajd060221", "Tester12" ) == false){
		            System.out.println("EFT redirect incorrectly worked for an Invalid account");
		            test.log(LogStatus.FAIL, "EFT redirect incorrectly worked for an Invalid account");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("EFT redirect displayed correct message for an Invalid account");
		            test.log(LogStatus.PASS, "EFT Redirect displayed correct message");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_Zengin_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Japan", "Japanese Yen (JPY)");
		//Choose Method and login
				if(OptionsLoginValueNegative(Utils.getChoiceSingle(driver), "ajd060221", "Tester12" ) == false){
		            System.out.println("Zengin redirect incorrectly worked for an Invalid account");
		            test.log(LogStatus.FAIL, "Zengin redirect incorrectly worked for an Invalid account");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("Zengin redirect displayed correct message for an Invalid account");
		            test.log(LogStatus.PASS, "Zengin Redirect displayed correct message");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_BPAY_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "Australian Dollar (AUD)");
		//Choose Method and login
				if(OptionsLoginValueNegative(Utils.getChoice2(driver), "ajd060221", "Tester12" ) == false){
		            System.out.println("BPAY redirect incorrectly worked for an Invalid account");
		            test.log(LogStatus.FAIL, "BPAY redirect incorrectly worked for an Invalid account");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("BPAY redirect displayed correct message for an Invalid account");
		            test.log(LogStatus.PASS, "BPAY Redirect displayed correct message");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_FPS_Login_NoPermissions() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("Hong Kong Special Administrative Region of China", "Hong Kong Dollar (HKD)");
		//Choose Method and login
				if(OptionsLoginValueNegative(Utils.getChoice1(driver), "ajd060221", "Tester12" ) == false){
		            System.out.println("FPS redirect incorrectly worked for an Invalid account");
		            test.log(LogStatus.FAIL, "FPS redirect incorrectly worked for an Invalid account");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("FPS redirect displayed correct message for an Invalid account");
		            test.log(LogStatus.PASS, "FPS  Redirect displayed correct message");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    @Test
    public void Deposit_DirectDeposit_Login_Invalid() throws InterruptedException {
    	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		test = report.startTest(nameofCurrMethod);
		//ONE
		DepositSelection("United States", "United States Dollar (USD)");
		//Choose Method and login
				if(OptionsLoginValueAlt(Utils.getChoice1(driver), "Deposit", "fancy1005", "tester12" ) == false){
		            System.out.println("Direct Deposit redirect allowed an invalid account");
		            test.log(LogStatus.FAIL, "Direct Deposit redirect allowed an invalid account");
		            Thread.sleep(3000);
		            LogoutCPAlt();
		        }
				else {
					//PASS
					System.out.println("Direct Deposit Redirect Successfully brought invalid account to top level");
		            test.log(LogStatus.PASS, "Direct Deposit Redirect Successfully brought invalid account to top level");
		            Thread.sleep(3000);
		            LogoutCPAlt();
				}
				
		    }
    
    
    
}
