/**
 * rsr 
 *
 *Aug 5, 2016
 */
package com.cucumber.framework.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;



public class ChromeBrowser {

	public Capabilities getChromeCapabilities() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, option);
		return capabilities;
	}

	public WebDriver getChromeDriver(Capabilities cap) {
		System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver");
		return new ChromeDriver(cap);
	}
	
	public WebDriver getChromeDriver(String hubUrl, Capabilities cap) throws MalformedURLException {
		return new RemoteWebDriver(new URL(hubUrl), cap);
	}

}
