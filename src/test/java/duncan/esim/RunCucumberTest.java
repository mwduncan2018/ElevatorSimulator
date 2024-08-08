package duncan.esim;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import duncan.esim.context.TestRunContext;

@CucumberOptions(
		features = "src/test/resources/features", 
		plugin = "json:target/cucumber-reports/cucumber.json", 
		tags = "")
class RunCucumberTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeSuite
	public static void beforeClass() {
	}

	@AfterSuite
	public static void afterClass() {
	}
}