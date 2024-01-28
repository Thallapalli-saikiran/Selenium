package common;

import java.io.File;
import java.util.ArrayList;
import java.util.Dictionary;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class PublicApp {
	


	public String ConfigFile = "D:\\NewProject\\Automation\\PublicApp.PublicApp\\src\\test\\java\\DataFiles\\App.csv";
    public String Streamfile = "D:\\NewProject\\Automation\\PublicApp.PublicApp\\src\\test\\java\\DataFiles\\App.csv";

//	public String ConfigFile = "src\\test\\resources\\Data_files\\secureqa_config.csv";
//    public String Streamfile = "src\\test\\resources\\Data_files\\secureqa_config.csv";

    public String Browsername = "Firefox";
    public String WebdriversPath = "C:\\Users\\SAI KIRAN\\WebDrivers\\";
    public WebDriver driver;
    public Dictionary ConfigData ;
    public ArrayList<ArrayList<String> > StreamList;
    public SoftAssert mySoftAssert =new SoftAssert();
    public File chosenFile = null;
    public String downloads_path="C:\\Users\\SAI KIRAN\\Downloads\\";
	
}
