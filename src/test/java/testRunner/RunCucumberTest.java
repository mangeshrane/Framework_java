package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utils.ResourceProvider;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "stepDefs")
public class RunCucumberTest {
	
}
