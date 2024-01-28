
package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "C:\\Users\\SAI KIRAN\\eclipse-workspace\\jen\\src\\test\\java\\FeatureFiles\\login.feature",
                                glue= {"StepDefinitions"}
                                ,monochrome=true
                                ,plugin= {"pretty",
                                        //"junit:target/JUnitReports/report_Blog.xml",
                                        //"json:target/JSONReports/report_Blog.json",
                                        "html:target/HTMLReports/f1.html"})
public class Test_Runner {
	


}
