package expert.os.books.architecture.patterns.hexagon.core;

public class Article {

    private final String id;
    private final String title;
    private final String content;
    private boolean isPublished;

    public Article(String id, String title, String content) {
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Title required");
        }
        this.id = id;
        this.title = title;
        this.content = content;
        this.isPublished = false;
    }

    public void publish() {
        if (this.content == null || this.content.length() < 100) {
            throw new IllegalStateException("Article must have at least 100 characters to publish.");
        }
        this.isPublished = true;
    }

    public String getId() { return id; }

    public boolean isPublished() { return isPublished; }

    public String getTitle() {
        return title;
    }
}
