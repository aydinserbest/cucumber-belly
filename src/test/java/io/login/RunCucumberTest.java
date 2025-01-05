package io.login;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
//@IncludeTags("")
//@ConfigurationParameter(key = "cucumber.filter.tags", value = "@Bank")  // This is an alternative to the above line, but did not work
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io.belly.skeleton")

public class RunCucumberTest {

}
