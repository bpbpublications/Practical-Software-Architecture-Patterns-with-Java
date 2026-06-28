package expert.os.books.architecture.patterns.remote.events;

import java.time.Instant;
import java.util.UUID;

public record UserRegisteredEvent(UUID id, Instant timestamp, UUID userId, String name, String email) {

    public UserRegisteredEvent(UUID userId, String name, String email) {
        this(UUID.randomUUID(), Instant.now(), userId, name, email);
    }
}