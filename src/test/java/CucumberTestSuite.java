import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "classpath:features/tugas"
//        tags = "@smoke or @regression" // kalau mau 2 tag / lebih
)
public class CucumberTestSuite {}
