package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.util.UUID;
import java.util.logging.Logger;

@ApplicationScoped
class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @Inject
    private Event<UserRegisteredEvent> cdiEventPublisher; // Native Jakarta EE Event Bus

    public UUID handle(RegisterUser request) {

        UUID newUserId = UUID.randomUUID();

        UserRegisteredEvent fact = new UserRegisteredEvent(newUserId, request.name(), request.email());

        LOGGER.info("[WRITE MODEL] Business rules processed successfully for user: " + newUserId);

        LOGGER.info("[EVENT BUS] Firing CDI Event...");
        cdiEventPublisher.fireAsync(fact);

        return newUserId;
    }
}