package test;

import static org.junit.Assert.assertNotEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.javafx.collections.MappingChange.Map;



public class TestTest{
  private WebDriver driver;
  private HashMap<String, Object> vars;
  JavascriptExecutor js ;
  private String baseUrl;
  
  private File csv;
  private BufferedReader br = null;
  List<String> data;
  
  @Before
  public void setUp() throws Exception{
	  System.setProperty("webdriver.firefox.bin","D:\\Firefox\\firefox.exe"); 
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\Linyo\\Downloads\\geckodriver.exe");
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 

   
    csv = new File("D:\\Selenium+Lab2020.csv");
    br = new BufferedReader(new FileReader(csv));

    
    String temLine = br.readLine();
    try{
        data = new ArrayList<>();
        while((temLine = br.readLine()) != null){
            data.add(temLine);
        }
    } catch(IOException e){
        e.printStackTrace();
    }
    
  }
  
  @Test
  public void test() {
	for(int i = 0; i < 19 ; i++){
	String[] temInf = data.get(i).split(",");
	System.out.println(data.get(i));
    driver.get("http://103.120.226.190/selenium-demo/git-repo");
    driver.findElement(By.name("user_number")).click();
    driver.findElement(By.name("user_number")).sendKeys(temInf[0]);
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys(temInf[1]);
    driver.findElement(By.cssSelector(".btn")).click();
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
    String text = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[4]/code")).getText();
    System.out.print(text);
    assertNotEquals("user number and password don't match!", text);
	  }
    
    
  }
}
