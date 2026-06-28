package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.UUID;

@ApplicationScoped
class UserRepository {

    private Map<UUID, User> users = new java.util.concurrent.ConcurrentHashMap<>();

    public void save(User user) {
        users.put(user.getId(), user);
    }

}
