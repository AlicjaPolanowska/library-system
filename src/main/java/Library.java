import java.sql.*;
import java.util.ArrayList;

public class Library {
    private String address;
    private String name;
    private int id;
    private ArrayList<Book> book_list;
    private  ArrayList<User> user_list;
    private  ArrayList<Card> card_list;

    public Library(String address, String name) {
        this.address = address;
        this.name = name;
        this.book_list = new ArrayList<Book>();
        this.user_list = new ArrayList<User>();
        this.card_list = new ArrayList<Card>();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Libraries(address, name) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, address);
                preparedStatement.setString(2, name);

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
