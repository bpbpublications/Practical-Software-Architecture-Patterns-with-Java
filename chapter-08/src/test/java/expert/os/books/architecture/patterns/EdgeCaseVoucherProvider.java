package expert.os.books.architecture.patterns;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigDecimal;
import java.util.stream.Stream;

class EdgeCaseVoucherProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of("FREE100",  new BigDecimal("9999.99"), new BigDecimal("0.00")),
                Arguments.of("SUMMER20", new BigDecimal("0.00"),    new BigDecimal("0.00"))
        );
    }
}