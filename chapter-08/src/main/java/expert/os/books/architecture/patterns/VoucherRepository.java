package expert.os.books.architecture.patterns;

public interface VoucherRepository {
    Voucher findByCode(String code);
}