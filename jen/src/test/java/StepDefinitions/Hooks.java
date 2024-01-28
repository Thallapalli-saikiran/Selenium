package StepDefinitions;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import common.PublicApp;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks extends PublicApp{
	
	private PublicApp base;
	
	public Hooks(PublicApp base)
	{
		this.base= base;
	}
	
	@Before
    public void initDriver() throws IOException {
            System.out.println("Open browser");
            if(base.Browsername.equalsIgnoreCase("chrome"))
            {
            System.setProperty("webdriver.chrome.driver",base.WebdriversPath.concat("chromedriver\\chromedriver.exe"));
            base.driver = new ChromeDriver();
            System.out.println("| Chrome Browser started successfully |");
            }
            else if(base.Browsername.equalsIgnoreCase("firefox"))
            {
                    System.setProperty("webdriver.gecko.driver",base.WebdriversPath.concat("geckodriver\\geckodriver.exe"));
                    base.driver = new FirefoxDriver();
                    System.out.println("| FireFox Browser started successfully |");
            }
            else if(base.Browsername.equalsIgnoreCase("edge"))
            {
                    System.setProperty("webdriver.edge.driver",base.WebdriversPath.concat("edgedriver\\msedgedriver.exe"));
                base.driver = new EdgeDriver();
                System.out.println("| Edge Browser started successfully |");
            }
            else {
                    System.setProperty("webdriver.chrome.driver",base.WebdriversPath.concat("chromedriver103\\chromedriver.exe"));
                    base.driver = new ChromeDriver();
                    System.out.println("| Chrome Browser started successfully |");
            }
            base.driver.manage().window().maximize();
            base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
            Reader reader = new FileReader(base.ConfigFile);
            ArrayList<String> list;
            base.ConfigData = new Hashtable<String, String>();
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            for(CSVRecord record : csvParser) {
                    list=new ArrayList<String>();
                    for (int i=0;i<record.size();i++)
                    {
                            list.add(record.get(i));
                    }
                    base.ConfigData.put(list.get(0),list.get(1));
            }

            System.out.println(base.ConfigData);

            Reader reader2 = new FileReader(base.Streamfile);
            System.out.println("base.Streamfile:"+base.Streamfile);
            ArrayList<String> list2;
            base.StreamList = new ArrayList<ArrayList<String> >();
            CSVParser csvParser2 = new CSVParser(reader2, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            for(CSVRecord record2 : csvParser2) {
                    list2=new ArrayList<String>();
                    for (int i=0;i<record2.size();i++)
                    {
                            list2.add(record2.get(i));
                    }
                    base.StreamList.add(list2);
                    }
            System.out.println(base.StreamList);
    }

    @AfterStep
public void afterScenario(Scenario scenario) throws Exception {
    base.mySoftAssert.assertAll();
}
    @After
    public void teardown() {
            System.out.println("Close browser");
            try{Thread.sleep(5*1000);}catch(InterruptedException e){System.out.println(e);}
//          base.driver.quit();
    }
	
	
	
}
