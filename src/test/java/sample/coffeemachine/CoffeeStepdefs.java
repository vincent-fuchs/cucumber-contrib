package sample.coffeemachine;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class CoffeeStepdefs {

    private String message;
    private Scenario scenario;

    @Before("@math")
    public void initWithMathSupport(Scenario scenario) {
        scenario.embed(
                ("Value = \\dfrac{ Why }{ How }").getBytes(), "text/formula");
    }

    @Before
    public void init(Scenario scenario) {
        this.scenario = scenario;
    }

    @When("^I order an? \"([^\"]*)\" with (\\d+) sugar$")
    public void I_order_a_with_sugar(String drinkType, int nbSugar) throws Throwable {
        scenario.embed(
                ("" +
                        "  /---------+     +------------+\n" +
                        "  |  Order  |---->|  Protocol  |\n" +
                        "  +---------/     +------------+").getBytes(), "text/asciidiag");
    }

    @Then("^the instruction generated should be \"([^\"]*)\"$")
    public void the_instruction_generated_should_be(String expectedProtocol) throws Throwable {
        assertThat(expectedProtocol).isIn("T:1:0", "C:2:0", "H::", "M:" + message);
    }

    @When("^the message \"([^\"]*)\" is sent$")
    public void the_message_is_sent(String message) throws Throwable {
        this.message = message;
    }

    @Given("^I've inserted (\\d+)€ in the machine$")
    public void I_ve_inserted_€_in_the_machine(int amountInEuro) throws Throwable {
        throw new PendingException();
    }

    @Then("^the report output should be$")
    public void the_report_output_should_be(String rawReport) throws Throwable {
    }
}
