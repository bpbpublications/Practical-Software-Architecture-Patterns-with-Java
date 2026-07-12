package expert.os.books.architecture.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Feature: Promotional Checkout Validations")
public class CheckoutServiceTest {

    CheckoutService checkoutService;

    @BeforeEach
    void setupService() {
        VoucherRepository fakeRepo = code -> switch (code) {
            case "SUMMER20" -> Optional.of(new Voucher("SUMMER20", new BigDecimal("0.20"), true));
            case "VIP-HALF" -> Optional.of(new Voucher("VIP-HALF", new BigDecimal("0.50"), true));
            case "FREE100" -> Optional.of(new Voucher("FREE100", new BigDecimal("1.00"), true));
            case "EXPIRED50" -> Optional.of(new Voucher("EXPIRED50", new BigDecimal("0.50"), false));
            default -> Optional.empty();
        };
        checkoutService = new CheckoutService(fakeRepo);
    }


    @Nested
    @DisplayName("Scenario Outline: Processing invalid or expired vouchers")
    class WhenApplyingInvalidVouchers {

        @ParameterizedTest(name = "When applying invalid voucher ''{0}''")
        @ValueSource(strings = {"EXPIRED50", "INVALID", "UNKNOWN", "   ", ""})
        @DisplayName("Then the final checkout price should remain unchanged")
        void shouldIgnoreInvalidCodes(String invalidCode) {
            BigDecimal cartTotal = new BigDecimal("100.00");

            BigDecimal finalPrice = checkoutService.applyVoucher(invalidCode, cartTotal);
            assertThat(finalPrice).isEqualByComparingTo(new BigDecimal("100.00"));
        }
    }

    @Nested
    @DisplayName("Scenario Outline: Processing standard active discounts")
    class WhenApplyingStandardDiscounts {

        @ParameterizedTest(name = "And cart is ${1}, When applying ''{0}'', Then price should be ${2}")
        @MethodSource("provideStandardDiscounts")
        @DisplayName("Then the final checkout price should be correctly discounted")
        void shouldCalculateCorrectFinalPrice(String code, BigDecimal cartTotal, BigDecimal expectedPrice) {

            BigDecimal finalPrice = checkoutService.applyVoucher(code, cartTotal);

            assertThat(finalPrice).isEqualByComparingTo(expectedPrice);
        }

        static Stream<Arguments> provideStandardDiscounts() {
            return Stream.of(
                    Arguments.of("SUMMER20", new BigDecimal("100.00"), new BigDecimal("80.00")),
                    Arguments.of("VIP-HALF", new BigDecimal("50.00"), new BigDecimal("25.00"))
            );
        }
    }

    @Nested
    @DisplayName("Scenario Outline: Processing extreme edge cases safely")
    class WhenApplyingExtremeEdgeCases {

        @ParameterizedTest(name = "And cart is ${1}, When applying ''{0}'', Then boundary result is ${2}")
        @ArgumentsSource(EdgeCaseVoucherProvider.class)
        @DisplayName("Then the system should handle the extreme boundary gracefully")
        void shouldHandleExtremeBoundaries(String code, BigDecimal cartTotal, BigDecimal expectedPrice) {

            BigDecimal finalPrice = checkoutService.applyVoucher(code, cartTotal);
            assertThat(finalPrice).isEqualByComparingTo(expectedPrice);
        }
    }
}
