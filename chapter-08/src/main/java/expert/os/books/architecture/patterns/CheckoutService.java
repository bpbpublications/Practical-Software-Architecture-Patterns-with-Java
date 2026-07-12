package expert.os.books.architecture.patterns;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
class CheckoutService {

    private static final Logger LOGGER = Logger.getLogger(CheckoutService.class.getName());
    private final VoucherRepository voucherRepository;

    @Inject
    public CheckoutService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public BigDecimal applyVoucher(String code, BigDecimal cartTotal) {
        LOGGER.info("Applying voucher with code: " + code);
        Optional<Voucher> voucher = voucherRepository.findByCode(code);

        return voucher.filter(Voucher::isActive)
                .map(v -> {
                    BigDecimal discountAmount = cartTotal.multiply(v.discountPercentage());
                    return cartTotal.subtract(discountAmount);
                }).orElseGet(() -> {
                    LOGGER.info("Voucher invalid or inactive. No discount applied.");
                    return cartTotal;
                });
    }
}