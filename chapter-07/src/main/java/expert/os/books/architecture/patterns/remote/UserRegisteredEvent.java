package expert.os.books.architecture.patterns.remote;

import java.time.Instant;
import java.util.UUID;

public record UserRegisteredEvent(UUID eventId,
                                  Instant timestamp,
                                  String userId,
                                  String name,
                                  String email) {

    public UserRegisteredEvent(String userId, String name, String email) {
        this(UUID.randomUUID(), Instant.now(), userId, name, email);
    }
}
