package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@ApplicationScoped
public class UserDashboardRepository {

    private static final Logger LOGGER = Logger.getLogger(UserDashboardRepository.class.getName());

    private final Map<String, UserDashboard> data = new ConcurrentHashMap<>();

    public Optional<UserDashboard> findDashboard(String userId) {
        LOGGER.info("[READ MODEL] Performing sub-millisecond read from NoSQL database...");
        return Optional.ofNullable(data.get(userId));
    }

    public void save(UserDashboard userDashboard) {
        data.put(userDashboard.userId(), userDashboard);
        LOGGER.info("[READ MODEL] Materialized view saved in NoSQL database for: " + userDashboard.userId());
    }
}
