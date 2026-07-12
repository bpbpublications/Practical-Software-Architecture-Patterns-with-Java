package expert.os.books.architecture.patterns;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
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
        Voucher voucher = voucherRepository.findByCode(code);

        // If voucher doesn't exist or is inactive, return the original total
        if (voucher == null || !voucher.isActive()) {
            LOGGER.info("Voucher invalid or inactive. No discount applied.");
            return cartTotal;
        }

        BigDecimal discountAmount = cartTotal.multiply(voucher.discountPercentage());
        return cartTotal.subtract(discountAmount);
    }
}