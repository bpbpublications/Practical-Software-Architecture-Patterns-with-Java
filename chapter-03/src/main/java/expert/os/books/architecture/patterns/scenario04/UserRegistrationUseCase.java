package expert.os.books.architecture.patterns.scenario04;

public class UserRegistrationUseCase {

    private final UserRepository repository;
    private final EmailService emailService;

    // Pure DI via Constructor
    public UserRegistrationUseCase(UserRepository repo, EmailService email) {
        this.repository = repo;
        this.emailService = email;
    }

    public void register(User user) { /* ... */ }
}
