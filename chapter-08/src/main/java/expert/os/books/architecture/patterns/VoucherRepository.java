package expert.os.books.architecture.patterns;

import java.util.Optional;

public interface VoucherRepository {
    Optional<Voucher> findByCode(String code);
}