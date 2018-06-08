import java.util.Date;

public class Book {
    private int id;
    private String author;
    private String code;
    private String title;
    private int pagesCount;
    private CategoriesEnum.Categories category;
    private Date date_from;
    private Date date_to;
    private Library library;
    private int card_id;

    public Book() {
    }

    public Book(String author, String code, String title, int pagesCount, CategoriesEnum.Categories category, Library library) {
        this.author = author;
        this.code = code;
        this.title = title;
        this.pagesCount = pagesCount;
        this.category = category;
        this.library = library;
        library.addBook(this);
    }

    public Book(int id, String author, String code, String title, int pages, CategoriesEnum.Categories categories,
                int card_id, Date dateF, Date dateT, Library lib) {
        this.id = id;
        this.author = author;
        this.code = code;
        this.title = title;
        this.pagesCount = pagesCount;
        this.category = category;
        this.library = library;
        this.date_from = dateF;
        this.date_to = dateT;
        this.library = lib;
        this.card_id = card_id;

        library.addBook(this);
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
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
