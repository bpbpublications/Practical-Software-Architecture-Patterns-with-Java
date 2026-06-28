package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/commands/users")
@ApplicationScoped
class UserCommandResource {

    @Inject
    private UserCommandService commandService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(CreateUserCommand command) {
        try {
            String newUserId = commandService.execute(command);
            String responseJson = String.format("{\"message\": \"Processing\", \"userId\": \"%s\"}", newUserId);
            return Response.accepted(responseJson).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}