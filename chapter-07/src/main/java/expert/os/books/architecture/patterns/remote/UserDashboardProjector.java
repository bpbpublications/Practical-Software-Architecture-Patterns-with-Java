package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
class UserDashboardProjector {

    private final Map<String, UserDashboardView> readDatabase = new HashMap<>();

    void onUserRegistered(@Observes UserRegisteredEvent event) {
        String flatView = String.format("%s (%s) - Account Active since %s",
                event.name(), event.email(), event.timestamp());

        readDatabase.put(event.userId(), new UserDashboardView(flatView));
    }

    public Optional<UserDashboardView> get(String userId) {
        return Optional.ofNullable(readDatabase.get(userId));
    }
}