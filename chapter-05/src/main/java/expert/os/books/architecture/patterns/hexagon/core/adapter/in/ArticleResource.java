package expert.os.books.architecture.patterns.hexagon.core.adapter.in;

import expert.os.books.architecture.patterns.hexagon.core.port.in.PublishArticleUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.logging.Logger;

/**
 * DRIVING ADAPTER 2: The REST Controller (For mobile apps or external APIs)
 * Translates an incoming HTTP JSON payload into a Use Case invocation.
 */
@ApplicationScoped
@Path("articles")
class ArticleResource {
    private static final Logger LOGGER = Logger.getLogger(ArticleResource.class.getName());

    private final PublishArticleUseCase publishUseCase;

    @Inject
    public ArticleResource(PublishArticleUseCase publishUseCase) {
        this.publishUseCase = publishUseCase;
    }

    @Path("{pathId}/publish")
    @POST
    public void handlePostRequest(@PathParam("pathId") String pathId) {
        LOGGER.info("[REST Adapter] Received HTTP POST to /articles/" + pathId + "/publish");
        publishUseCase.publishArticle(pathId);
    }
}