package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
class UserCommandService {

    @Inject
    private Event<UserRegisteredEvent> cdiEventPublisher; // Native Jakarta EE Event Bus


    public String execute(CreateUserCommand command) {
        String newUserId = UUID.randomUUID().toString().substring(0, 8);
        UserRegisteredEvent fact = new UserRegisteredEvent(newUserId, command.name(), command.email());
        cdiEventPublisher.fire(fact);
        return newUserId;
    }
}