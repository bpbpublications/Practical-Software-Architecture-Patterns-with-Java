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
class ArticleBean implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(ArticleBean.class.getName());

    private PublishArticleUseCase publishUseCase;

    private String inputArticleId;

    ArticleBean() {
    }

    @Inject
    public ArticleBean(PublishArticleUseCase publishUseCase) {
        this.publishUseCase = publishUseCase;
    }

    public void publish() {
        LOGGER.info("\n[JSF Adapter] Admin clicked 'Publish' button for: " + inputArticleId);
        publishUseCase.publishArticle(inputArticleId);
    }

    public String getInputArticleId() {
        return inputArticleId;
    }

    public void setInputArticleId(String inputArticleId) {
        this.inputArticleId = inputArticleId;
    }
}
