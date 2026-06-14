package expert.os.books.architecture.patterns.hexagon.core.adapter.in;

import expert.os.books.architecture.patterns.hexagon.core.port.in.PublishArticleUseCase;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.logging.Logger;


/**
 * DRIVING ADAPTER 1 (Backend Controller): The JSF Backing Bean
 * Translates the UI button click into a Use Case invocation.
 */
@Named("articleBean")
@ViewScoped
public class ArticleBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(ArticleBean.class.getName());

    private PublishArticleUseCase publishUseCase;

    private String articleId;

    ArticleBean() {
    }

    @Inject
    public ArticleBean(PublishArticleUseCase publishUseCase) {
        this.publishUseCase = publishUseCase;
    }

    public void publish() {
        LOGGER.info("\n[JSF Adapter] Admin clicked 'Publish' button for: " + articleId);
        publishUseCase.publishArticle(articleId);
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
}
