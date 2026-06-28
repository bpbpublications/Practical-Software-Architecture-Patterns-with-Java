package expert.os.books.architecture.patterns.remote;

import java.util.UUID;

public record UserDashboard(UUID userId, String name, String email) {}