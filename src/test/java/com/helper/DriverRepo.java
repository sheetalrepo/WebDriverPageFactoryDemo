package com.helper;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum DriverRepo {

	FIREFOX {
		public WebDriver getDriver() {
			String current_os = System.getProperty("os.name");
			log.info("##Current OS: " + current_os);
			if (current_os.contains("Mac")) {
				log.info("MAC: FF initialized");
				System.setProperty("webdriver.gecko.driver", getCommonPath("geckodriver.exe"));
				return new FirefoxDriver();
			} else if (current_os.contains("Windows")) {
				log.info("WINDOW: FF initialized");
				System.setProperty("webdriver.gecko.driver", getCommonPath("geckodriver.exe"));
				return new FirefoxDriver();
			} else {
				throw new RuntimeException("Invalid OS for Firefox");
			}
		}

	},
	CHROME {
		public WebDriver getDriver() {
			String current_os = System.getProperty("os.name");
			log.info("##Current OS: " + current_os);

			if (current_os.contains("Mac")) {
				log.info("MAC: Chrome initialized");
				System.setProperty("webdriver.chrome.driver", getCommonPath("chromedriver.exe"));
				return new ChromeDriver();	
			} else if (current_os.contains("Window")) {
				log.info("### WINDOW: Chrome initialized");
				//System.setProperty("webdriver.chrome.driver", getCommonPath("chromedriver.exe"));
				return new ChromeDriver();	
			} else {
				throw new RuntimeException("Invalid OS for chrome");
			}
		}
	};

	WebDriver driver;
	Logger log = Logger.getLogger(getClass());

	DriverRepo(WebDriver drv) {
		PropertyConfigurator.configure("log4j.properties");
		this.driver = drv;
	}

	DriverRepo() {
	}

	public WebDriver getDriver() {
		return driver;
	}

	
	public String getCommonPath(String driver) {
		Path currentRelativePath = Paths.get("");
		String absPath = currentRelativePath.toAbsolutePath().toString();

		//current project path
		System.out.println("Absolute Path: " + absPath); 
		String fileToBeRead = absPath + "\\src\\test\\resources\\drivers\\"+driver;
		System.out.println("Driver path: " + fileToBeRead);
		
		//Backslash for windows + fwd slash for Linux(jenkin) will be handled automatically
		String fileToBeReadConverted = FilenameUtils.separatorsToSystem(fileToBeRead);
		System.out.println("Driver Final Path: "+ fileToBeReadConverted);
		return fileToBeReadConverted;
	}
}
