package expert.os.books.architecture.patterns.remote.dto;

import java.util.UUID;

public record UserCreatedResponse(UUID id, String name, String email, String password) {
}
