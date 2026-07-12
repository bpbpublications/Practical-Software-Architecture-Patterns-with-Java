package expert.os.books.architecture.patterns;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class VoucherRepositoryMemory implements VoucherRepository {

    @Override
    public Optional<Voucher> findByCode(String code) {
        return Optional.of(new Voucher(code, new java.math.BigDecimal("0.20"), true));
    }
}
