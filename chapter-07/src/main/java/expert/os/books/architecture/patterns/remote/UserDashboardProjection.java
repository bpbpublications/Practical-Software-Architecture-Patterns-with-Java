package expert.os.books.architecture.patterns.remote;

import expert.os.books.architecture.patterns.remote.events.UserRegisteredEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.ObservesAsync;
import jakarta.inject.Inject;

import java.util.logging.Logger;

@ApplicationScoped
class UserDashboardProjection {

    private static final Logger LOGGER = Logger.getLogger(UserDashboardProjection.class.getName());

    @Inject
    private UserDashboardRepository repository;

    /**
     * The @Observes annotation ties this method to the CDI Event Publisher.
     * It completely decouples the Projection from the Write Model.
     */
    public void onUserRegistered(@ObservesAsync UserRegisteredEvent event) {

        repository.save(new UserDashboard(event.userId(), event.name(), event.email()));
        LOGGER.info("[PROJECTION] Materialized view updated in NoSQL DB for: " + event.userId());
    }
}