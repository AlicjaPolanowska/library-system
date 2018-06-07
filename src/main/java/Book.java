import java.sql.*;
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

    public Book() {
    }

    public Book(String author, String code, String title, int pagesCount, CategoriesEnum.Categories category,Library library) {
        this.author = author;
        this.code = code;
        this.title = title;
        this.pagesCount = pagesCount;
        this.category = category;

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Books(author, code, title, pagesCount, category, library_id) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, author);
                preparedStatement.setString(2, code);
                preparedStatement.setString(3, title);
                preparedStatement.setInt(4, pagesCount);
                preparedStatement.setInt(5, category.ordinal());
                preparedStatement.setInt(6, library.getId());

                int inserted = preparedStatement.executeUpdate();

                if (inserted != 1) {
                    throw new IllegalStateException(String.format("Should insert one row. Actually inserted: %d", inserted));
                }

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (!generatedKeys.next()) {
                        throw new IllegalStateException("Query did not return created primary key");
                    }

                    this.setId((int) generatedKeys.getLong(1));
                    System.out.println("Generated id is = " + this.getId());
                }
            } catch (SQLException ex) {
                throw new IllegalStateException("Could not execute query", ex);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        library.addBook(this);
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
