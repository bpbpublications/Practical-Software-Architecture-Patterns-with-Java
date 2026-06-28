package expert.os.books.architecture.patterns.remote;

import java.util.UUID;

public record UserResponse(UUID userId, String message) {
}
