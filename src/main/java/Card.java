import java.util.ArrayList;
import java.util.Date;

public class Card {
    private int id;
    private ArrayList<Book> book_list;
    private User user;
    private Library library;

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

    public ArrayList<Book> getBook_list() {
        return book_list;
    }

    public void addBook(Book book) {
        if (this.book_list == null) {
            this.book_list = new ArrayList<Book>();
        }
        this.book_list.add(book);
        book.setDate_from(new Date());
        Date dateTo = new Date();
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        book.setDate_to(new Date(dateTo.getTime() + (7 * DAY_IN_MS)));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Card(User user, Library library) {
        this.user = user;
        this.library = library;
    }

    public Card(User user, Library library, int id) {
        this.user = user;
        this.library = library;
        this.id = id;
        this.book_list = new ArrayList<Book>();
    }

    public Card() {
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", book_list=" + book_list +
                ", user=" + user +
                '}';
    }
}
