public class Book {
    private String author;
    private String code;
    private String title;
    private int pagesCount;
    private CategoriesEnum.Categories category;

    public Book() {
    }

    public Book(String author, String code, String title, int pagesCount, CategoriesEnum.Categories category) {
        this.author = author;
        this.code = code;
        this.title = title;
        this.pagesCount = pagesCount;
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public CategoriesEnum.Categories getCategory() {
        return category;
    }

    public void setCategory(CategoriesEnum.Categories category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", pagesCount=" + pagesCount +
                ", category=" + category +
                '}';
    }
}
