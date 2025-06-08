public class Story {
    private String title;
    private String content;
    private String author;

    public Story(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + "," + content + "," + author;
    }

    public static Story fromString(String line) {
        String[] parts = line.split(",", 3);
        if (parts.length == 3) {
            return new Story(parts[0], parts[1], parts[2]);
        }
        return null;
    }
}