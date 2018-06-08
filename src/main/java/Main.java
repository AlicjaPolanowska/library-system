import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void connect() {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/my-local", "sa", "");) {
            try (Statement statement = connection.createStatement();) {
                statement.execute("CREATE TABLE IF NOT EXISTS USERS (" +
                        "first_name varchar NOT NULL," +
                        "last_name varchar NOT NULL," +
                        "age number(3) NOT NULL," +
                        "address varchar NOT NULL," +
                        "id varchar PRIMARY KEY AUTO_INCREMENT," +
                        ");" +
                        "CREATE TABLE IF NOT EXISTS Books (" +
                        "id number PRIMARY KEY AUTO_INCREMENT," +
                        "author varchar NOT NULL," +
                        "code varchar NOT NULL," +
                        "title varchar NOT NULL," +
                        "pagesCount NUMBER(6)," +
                        "category number," +
                        "card_id number," +
                        "date_from date," +
                        "date_to date," +
                        "library_id number" +
                        ");" +
                        "CREATE TABLE IF NOT EXISTS Cards (" +
                        "id varchar PRIMARY KEY AUTO_INCREMENT," +
                        "user_id number, " +
                        "library_id varchar" +
                        ");" +
                        "CREATE TABLE IF NOT EXISTS Libraries (" +
                        "id NUMBER PRIMARY KEY AUTO_INCREMENT," +
                        "address varchar NOT NULL," +
                        "name varchar NOT NULL" +
                        ");"
                );
            } catch (SQLException ex) {
                throw new IllegalStateException(ex);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello!");

        /********
         * Create Users, Books, Cards, Libraries entities in db
         ********/
        connect();


        /********
         * Create objects to use them later
         * Print objects to see if created right
         ********/
        Library library = new Library("ul Spokojna 14 23-976 Monachium", "Słoneczna library");

        Book bookOne = new Book("Tim_Peake", "AAAbC123", "Zapytaj_astonautę", 261, CategoriesEnum.Categories.Astronomia, library);
        System.out.println(bookOne.toString());

        User usr = new User("Marek", "Marecki", 19, "ul. Lwowska 12 15-676 Lwów");
        User usr1 = new User("Marcin", "Meksyk", 69, "ul. Warszawska 12 Lwów");
        System.out.println(usr.toString());

        Book bookTwo = new Book("J.R.R Tolkien", "Zdd908uY", "Władca pierścieni", 896, CategoriesEnum.Categories.Fantastyka, library);
        System.out.println(bookTwo.toString());

        Card card1 = new Card(usr, library);
        System.out.println(card1.toString());

        /********
         * Simulate adding books to library
         * Simulate adding new user to system
         * Simulate creating new card for user
         * Simulate lending a book
         ********/
        library.addBook(bookOne);
        library.addBook(bookTwo);
        library.addUser(usr);
        library.addCard(card1);
        card1.addBook(bookOne);
        System.out.println(library.toString());


        /********
         * Insert data to db
         ********/
        System.out.println("\nInserted records id:");
        Inserted.insBook(bookOne);
        Inserted.insBook(bookTwo);

        Inserted.insUser(usr);
        Inserted.insUser(usr1);

        Inserted.insCard(card1);

        Inserted.insLibrary(library);

        /********
         * Select data from db
         ********/
        System.out.println("\nSelected from DB:");
        User u = Selected.getUser(2);
        System.out.println(u.toString());

        Card c = Selected.getCard(1);
        System.out.println(c.toString());
    }
}
