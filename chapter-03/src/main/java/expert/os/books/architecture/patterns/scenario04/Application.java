package expert.os.books.architecture.patterns.scenario04;

public class Application {

    public static void main(String[] args) {
        // 1. Instantiate lower-level infrastructure
        UserRepository repo = new SqlUserRepository();
        EmailService email = new SmtpEmailService();

        // 2. Inject into higher-level domains
        UserRegistrationUseCase registration = new UserRegistrationUseCase(repo, email);

        // 3. Start the application
        registration.register(new User("Alice"));
    }
}
