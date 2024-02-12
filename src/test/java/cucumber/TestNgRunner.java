package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"src/test/java/cucumber"},glue={"Stepdef"},monochrome = true,tags= "@submitorder",plugin= {"html:cucumber/report.html"})
public class TestNgRunner extends AbstractTestNGCucumberTests{

}
