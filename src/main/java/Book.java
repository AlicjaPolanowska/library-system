import java.util.Date;

public class Book {
    private String author;
    private String code;
    private String title;
    private int pagesCount;
    private CategoriesEnum.Categories category;
    private Date date_from;
    private Date date_to;

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

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
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
