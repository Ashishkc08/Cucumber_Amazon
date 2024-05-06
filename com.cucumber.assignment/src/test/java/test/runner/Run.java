package test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/LoginFeature.feature", ".//Features/Navigation.feature"},
		glue = "StepDefinations",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/cucumber-reports.html"},
		tags = "@add_to_cart or @all"
		)
public class Run {}
