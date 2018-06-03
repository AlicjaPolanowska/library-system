import java.util.ArrayList;

public class Card {
    private  int id;
    private ArrayList<Book> book_list;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Card(int id, ArrayList<Book> book_list, User user) {
        this.id = id;
        this.book_list = book_list;
        this.user = user;
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
