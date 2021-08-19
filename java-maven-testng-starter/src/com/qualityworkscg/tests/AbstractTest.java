package com.qualityworkscg.tests;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qualityworkscg.pages.Page;

public abstract class  AbstractTest {
  
  protected static Page page;
  
  @BeforeTest
  @Parameters({"url"})
  public void setup(String url) {
    // Set the path to the geckodriver
    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
    
    // Instantiate a new Page and navigate 
    // to the url specified in the testng.xml
    page = new Page(new ChromeDriver());
    page.navigate(url);
  }

  @AfterTest
  public void afterTest() {
    page.tearDown();
  }
}