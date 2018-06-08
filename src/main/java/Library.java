import java.util.ArrayList;

public class Library {
    private String address;
    private String name;
    private int id;
    private ArrayList<Book> book_list;
    private ArrayList<User> user_list;
    private ArrayList<Card> card_list;

    public Library(String address, String name) {
        this.address = address;
        this.name = name;
        this.book_list = new ArrayList<Book>();
        this.user_list = new ArrayList<User>();
        this.card_list = new ArrayList<Card>();
    }

    public Library(String address, String name, int id) {
        this.address = address;
        this.name = name;
        this.id = id;
        this.book_list = new ArrayList<Book>();
        this.user_list = new ArrayList<User>();
        this.card_list = new ArrayList<Card>();
    }

    public Library() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBook_list() {
        return book_list;
    }

    public void addBook(Book b) {
        this.book_list.add(b);
    }

    public ArrayList<User> getUser_list() {
        return user_list;
    }

    public void addUser(User u) {
        this.user_list.add(u);
    }

    public ArrayList<Card> getCard_list() {
        return card_list;
    }

    public void addCard(Card c) {
        this.card_list.add(c);
    }

    @Override
    public String toString() {
        return "Library{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", book_list=" + book_list +
                ", user_list=" + user_list +
                ", card_list=" + card_list +
                '}';
    }
}
