package expert.os.books.architecture.patterns.remote;

import expert.os.books.architecture.patterns.remote.events.UserRegisteredEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.ObservesAsync;
import jakarta.inject.Inject;

import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@ApplicationScoped
public class UserDashboardService {

    private static final Logger LOGGER = Logger.getLogger(UserDashboardService.class.getName());

    @Inject
    private UserDashboardRepository repository;

    /**
     * The @Observes annotation ties this method to the CDI Event Publisher.
     * It completely decouples the Projection from the Write Model.
     */
    void onUserRegistered(@ObservesAsync UserRegisteredEvent event) {

        repository.save(new UserDashboard(event.userId(), event.name(), event.email()));
        LOGGER.info("[PROJECTION] Materialized view updated in NoSQL DB for: " + event.userId());
    }

    public Optional<UserDashboard> findDashboard(UUID userId) {
        return repository.findDashboard(userId);
    }
}