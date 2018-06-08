import java.sql.*;
import java.util.ArrayList;

public class Card {
    private  int id;
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

    public void setBook_list(ArrayList<Book> book_list) {
        this.book_list = book_list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Card( User user,Library library) {
        this.user = user;
        this.library=library;
    }

    public Card( User user,Library library,int id) {
        this.user = user;
        this.library=library;
        this.id=id;
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
