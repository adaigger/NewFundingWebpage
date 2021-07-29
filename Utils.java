package NewFundingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {

   public static WebDriver getDriver () {
       System.setProperty("webdriver.gecko.driver", "C:/Users/daigg/Desktop/selenium/geckodriver-v0.29.0-win32/geckodriver.exe");
       WebDriver driver = new FirefoxDriver();
       return driver;
   }
    
   public static boolean killDriver () {
       System.out.println("Not yet implemeted...");
       return true;
   }
   
   public static WebElement getChoiceSingle(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice/div/div[1]/div/div/div[2]/p/am-button/a"));
   }
   
   public static WebElement getChoice1(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[1]/div/div[1]/div/div/div[2]/p/am-button/a"));
   }
   
   public static WebElement getChoice2(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div[1]/div/div/div[2]/p/am-button/a"));
   }
   
   public static WebElement getChoice3(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[3]/div/div[1]/div/div/div[2]/p/am-button/a"));
   }
   
   public static WebElement getChoice4(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[4]/div/div[1]/div/div/div[2]/p/am-button/a"));
   }
   
   public static WebElement getChoice5(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[5]/div/div[1]/div/div/div[2]/p/am-button/a"));
   }
   
   public static WebElement getChoice6(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[6]/div/div[1]/div/div/div[2]/p/am-button/a"));
   }
   
   public static WebElement getPosChoice1(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/div/div[1]/position-transfer-method-choice/div/div[3]/am-button/a"));
   }
   
   public static WebElement getPosChoice2(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/div/div[2]/position-transfer-method-choice/div/div[3]/am-button/a"));
   }
   
   public static WebElement getPosChoice3(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/div/div[3]/position-transfer-method-choice/div/div[3]/am-button/a"));
   }
   
   public static WebElement getPosChoice4(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/div/div[4]/position-transfer-method-choice/div/div[3]/am-button/a"));
   }
   
   public static WebElement getPosChoice5(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/div/div[5]/position-transfer-method-choice/div/div[3]/am-button/a"));
   }
   
   public static WebElement getPosChoice6(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/div/div[6]/position-transfer-method-choice/div/div[3]/am-button/a"));
   }
   
   public static WebElement getNotAvailable(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div/am-page/div/div[2]/ng-include/section/div/div/div/div/h3"));
   }
   
   public static WebElement getCPPositionsHeader(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/am-bar-page-header/div/am-page-header/section/div/div/div[1]/h3"));
   }		
   
   public static WebElement getCPPositionsHeaderAlt(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div/am-page/div/div[1]/am-page-header/section/div/div/div[1]/h3"));
   }	
   
   public static WebElement getRollChoice1(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[1]/div/div/div/div/div[2]/p/am-button/a"));
   }
   
   public static WebElement getRollChoice2(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/cash-method-choice[2]/div/div/div/div/div[2]/p/am-button/a"));
   }
   
   public static WebElement getRollChoiceSingle(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[3]/div/div/div/div/funding-method-search/div[2]/div/div/div/position-transfer-method-choice/div/div[3]/am-button/a"));
   }
   
   
   
   
   
    
}