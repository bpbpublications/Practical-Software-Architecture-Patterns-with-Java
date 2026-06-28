package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.util.UUID;
import java.util.logging.Logger;

@ApplicationScoped
class UserRegistrationHandler {

    private static final Logger LOGGER = Logger.getLogger(UserRegistrationHandler.class.getName());

    @Inject
    private Event<UserRegisteredEvent> cdiEventPublisher; // Native Jakarta EE Event Bus

    public String handle(RegisterUser request) {

        String newUserId = UUID.randomUUID().toString().substring(0, 8);

        UserRegisteredEvent fact = new UserRegisteredEvent(newUserId, request.name(), request.email());

        LOGGER.info("[WRITE MODEL] Business rules processed successfully for user: " + newUserId);

        LOGGER.info("[EVENT BUS] Firing CDI Event...");
        cdiEventPublisher.fireAsync(fact);

        return newUserId;
    }
}