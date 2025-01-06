package io.login;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
//@SelectPackages("features")
@SelectClasspathResource("features")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
//@IncludeTags("runnerClassTag")  // başa @ YAZMA
//@ConfigurationParameter(key = "cucumber.filter.tags", value = "@runnerClassTag")
     // This is an alternative to the above line, bu satırla run edince, @selectedbooks tag'li senaryo çalışır.
//ama çıktıda diğer senaryoların her biri için
// tek tek -'cucumber.filter.tags=@selectedbooks' did not match this scenario- uyarısı veriyor

//junit-platform.properties dosyası içinden de ayarla bu gibi tag filan run edebiliyoruz
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io.login.step_definitions")


public class RunCucumberTest {

}
