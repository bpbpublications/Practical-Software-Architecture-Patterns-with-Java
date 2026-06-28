package expert.os.books.architecture.patterns.remote;

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
    private UserRegistrationHandler registrationHandler;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(RegisterUser request) {
        try {
            String newUserId = registrationHandler.handle(request);

            // CRITICAL ARCHITECTURE NOTE:
            // We return 202 ACCEPTED (not 200 OK or 201 Created).
            // In an EDA/CQRS system, returning 202 tells the client "We received
            // your request and are processing it asynchronously, but the read
            // model might not be immediately updated."
            String responseJson = String.format("{\"message\": \"Processing\", \"userId\": \"%s\"}", newUserId);
            return Response.accepted(responseJson).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}