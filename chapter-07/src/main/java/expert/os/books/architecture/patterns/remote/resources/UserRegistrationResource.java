package expert.os.books.architecture.patterns.remote.resources;

import expert.os.books.architecture.patterns.remote.RegisterUser;
import expert.os.books.architecture.patterns.remote.dto.UserCreatedResponse;
import expert.os.books.architecture.patterns.remote.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/users/register")
@ApplicationScoped
class UserRegistrationResource {

    @Inject
    private UserService registrationHandler;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(RegisterUser request) {
        try {
            var newUser = registrationHandler.handle(request);
            return Response.accepted(newUser).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}