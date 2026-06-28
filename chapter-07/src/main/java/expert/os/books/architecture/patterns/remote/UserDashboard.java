package expert.os.books.architecture.patterns.remote;

import java.util.UUID;

record UserDashboard(UUID userId, String name, String email) {}