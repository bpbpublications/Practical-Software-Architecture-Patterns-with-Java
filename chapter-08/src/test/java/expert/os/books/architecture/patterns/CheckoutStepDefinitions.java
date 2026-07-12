package expert.os.books.architecture.patterns;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.junit.Before;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ApplicationScoped
public class CheckoutStepDefinitions {

    // Internal State shared across the Given/When/Then steps

    private CheckoutService checkoutService;
    private BigDecimal cartTotal;
    private BigDecimal finalPrice;

    @PostConstruct
    void setupScenario() {
        // A Fake Repository implementing our test data state in-memory
        VoucherRepository fakeRepo = code -> switch (code) {
            case "SUMMER20" -> new Voucher("SUMMER20", new BigDecimal("0.20"), true);
            case "VIP-HALF" -> new Voucher("VIP-HALF", new BigDecimal("0.50"), true);
            case "FREE100"  -> new Voucher("FREE100",  new BigDecimal("1.00"), true);
            case "EXPIRED50"-> new Voucher("EXPIRED50",new BigDecimal("0.50"), false);
            default -> null; // Unknown/Invalid vouchers return null
        };
        checkoutService = new CheckoutService(fakeRepo);
    }

    // --- THE CONTEXT (Given) ---

    @Given("my shopping cart total is ${bigdecimal}")
    public void my_shopping_cart_total_is(BigDecimal total) {
        this.cartTotal = total;
    }

    @Given("a valid voucher {string} exists")
    public void a_valid_voucher_exists(String code) {
        // In a true End-to-End test, this step would seed a database.
        // For our Domain test, the Fake Repository is already pre-seeded in @Before.
    }

    // --- THE ACTION (When) ---

    // Stacking annotations allows us to reuse the exact same Java logic
    // regardless of how the business analyst phrased the Gherkin step!
    @When("I apply the invalid voucher {string}")
    @When("I apply the voucher {string}")
    public void i_apply_the_voucher(String code) {
        this.finalPrice = checkoutService.applyVoucher(code, cartTotal);
    }

    // --- THE VERIFICATION (Then) ---

    @Then("the final checkout price should remain unchanged at ${bigdecimal}")
    @Then("the final checkout price should be ${bigdecimal}")
    @Then("the system should handle the extreme boundary and return ${bigdecimal}")
    public void the_final_checkout_price_should_be(BigDecimal expectedPrice) {
        // Fluent AssertJ Assertion
        assertThat(finalPrice)
                .as("The calculated price did not match the business specification!")
                .isEqualByComparingTo(expectedPrice);
    }
}