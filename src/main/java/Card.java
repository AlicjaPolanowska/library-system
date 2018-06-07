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
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Cards(user_id,library_id) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setInt(2, library.getId());
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
