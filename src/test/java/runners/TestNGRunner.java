
package runners;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.testng.AllureTestNg;

@Listeners({AllureTestNg.class})
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.myproject.steps",
    plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] dataProvider(){
        return super.scenarios();
    }
    @Test(dataProvider = "dataProvider")
    public void runCucumberTests(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        super.runScenario(pickleWrapper,featureWrapper);
    }
}
    