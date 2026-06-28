package expert.os.books.architecture.patterns.remote.dto;

import java.util.UUID;

public record UserDashboardResponse(UUID userId, String name, String email) {}