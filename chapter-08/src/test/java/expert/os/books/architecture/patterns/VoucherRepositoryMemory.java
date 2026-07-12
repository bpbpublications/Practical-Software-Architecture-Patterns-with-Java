package expert.os.books.architecture.patterns;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VoucherRepositoryMemory implements VoucherRepository {

    @Override
    public Voucher findByCode(String code) {
        return new Voucher(code, new java.math.BigDecimal("0.20"), true);
    }
}
