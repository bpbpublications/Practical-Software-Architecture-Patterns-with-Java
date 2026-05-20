package expert.os.books.architecture.patterns;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;
import dev.langchain4j.rag.DefaultRetrievalAugmentor;
import dev.langchain4j.rag.RetrievalAugmentor;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.mongodb.MongoDbEmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class AiConfiguration {

    @Inject
    @ConfigProperty(name = "mongodb.connection-string")
    private String config;

    @Produces
    @ApplicationScoped
    EmbeddingStore<TextSegment> embeddingStore() {
        MongoClient mongoClient =
                MongoClients.create(System.getenv("MONGODB_ATLAS_URI"));
        return MongoDbEmbeddingStore.builder()
                .fromClient(mongoClient)
                .databaseName("cards")
                .collectionName("Card")
                .build();
    }

    @Produces
    @ApplicationScoped
    EmbeddingModel embeddingModel(
            @ConfigProperty(name = "openai.api-key")
            String apiKey) {

        return OpenAiEmbeddingModel.builder()
                .apiKey(apiKey)
                .modelName("text-embedding-3-small")
                .build();
    }

    @Produces
    @ApplicationScoped
    ContentRetriever contentRetriever(
            EmbeddingStore<TextSegment> embeddingStore,
            EmbeddingModel embeddingModel) {

        return EmbeddingStoreContentRetriever.builder()
                .embeddingStore(embeddingStore)
                .embeddingModel(embeddingModel)
                .maxResults(3)
                .build();
    }

    @Produces
    @ApplicationScoped
    RetrievalAugmentor retrievalAugmentor(
            EmbeddingStore<TextSegment> embeddingStore,
            EmbeddingModel embeddingModel) {

        ContentRetriever retriever =
                EmbeddingStoreContentRetriever.builder()
                        .embeddingStore(embeddingStore)
                        .embeddingModel(embeddingModel)
                        .maxResults(3)
                        .build();

        return DefaultRetrievalAugmentor.builder()
                .contentRetriever(retriever)
                .build();
    }
}