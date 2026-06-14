package expert.os.books.architecture.patterns.hexagon.core.adapter.in;

import expert.os.books.architecture.patterns.hexagon.core.Article;
import expert.os.books.architecture.patterns.hexagon.core.port.in.PublishArticleUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.logging.Logger;

/**
 * DRIVING ADAPTER 2: The REST Controller (For mobile apps or external APIs)
 * Translates an incoming HTTP JSON payload into a Use Case invocation.
 */
@ApplicationScoped
@Path("articles")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ArticleResource {
    private static final Logger LOGGER = Logger.getLogger(ArticleResource.class.getName());

    private final PublishArticleUseCase publishUseCase;

    @Inject
    public ArticleResource(PublishArticleUseCase publishUseCase) {
        this.publishUseCase = publishUseCase;
    }

    ArticleResource() {
        this.publishUseCase = null;
    }

    @Path("{pathId}/publish")
    @POST
    public Article handlePostRequest(@PathParam("pathId") String pathId) {
        LOGGER.info("[REST Adapter] Received HTTP POST to /articles/" + pathId + "/publish");
        publishUseCase.publishArticle(pathId);
    }
}