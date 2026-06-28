package expert.os.books.architecture.patterns.remote;

import expert.os.books.architecture.patterns.remote.resources.UserRegisteredEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.util.UUID;
import java.util.logging.Logger;

@ApplicationScoped
class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @Inject
    private UserRepository userRepository;

    @Inject
    private Event<UserRegisteredEvent> cdiEventPublisher; // Native Jakarta EE Event Bus

    public UserCreatedResponse handle(RegisterUser request) {

        UUID newUserId = UUID.randomUUID();

        UserRegisteredEvent fact = new UserRegisteredEvent(newUserId, request.name(), request.email());
        String randomPassword = UUID.randomUUID().toString().substring(0, 8);

        var user = new User(newUserId, request.name(), request.email(), randomPassword);
        userRepository.save(user);
        LOGGER.info("[WRITE MODEL] Business rules processed successfully for user: " + newUserId);

        LOGGER.info("[EVENT BUS] Firing CDI Event...");
        cdiEventPublisher.fireAsync(fact);

        return new UserCreatedResponse(newUserId, request.name(), request.email(), randomPassword);
    }
}