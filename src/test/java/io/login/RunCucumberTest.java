package io.login;
import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
//@IncludeTags("")
//@ConfigurationParameter(key = "cucumber.filter.tags", value = "@Bank")  // This is an alternative to the above line, but did not work
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io.belly.skeleton")

public class RunCucumberTest {

}
