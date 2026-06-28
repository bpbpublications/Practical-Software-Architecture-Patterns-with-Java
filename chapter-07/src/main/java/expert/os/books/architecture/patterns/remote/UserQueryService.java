package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
class UserQueryService {

    @Inject
    private UserDashboardProjector projector;

    public UserDashboardView getUserDashboard(String userId) {
        return projector.get(userId).orElseThrow();
    }
}