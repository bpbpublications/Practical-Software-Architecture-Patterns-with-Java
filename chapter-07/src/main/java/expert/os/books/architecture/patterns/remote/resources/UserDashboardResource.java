package expert.os.books.architecture.patterns.remote.resources;

import expert.os.books.architecture.patterns.remote.UserDashboardRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/api/v1/dashboards/users")
@ApplicationScoped
class UserDashboardResource {

    @Inject
    private UserDashboardRepository dashboardRepository;

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDashboard(@PathParam("userId") UUID userId) {
        var view = dashboardRepository.findDashboard(userId)
                .orElseThrow(() -> new WebApplicationException("User not found: " + userId, Response.Status.NOT_FOUND));

        return Response.ok(view).build();
    }
}