package expert.os.books.architecture.patterns.scenario02;

// The Abstraction: Supposed to completely hide the storage mechanism
public interface UserRepository {
    User findById(String id);
}
