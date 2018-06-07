import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static void connect(){

        try(Connection connection=DriverManager.getConnection("jdbc:h2:~/my-local","sa","");){
            System.out.println("dupa");
            try(Statement statement=connection.createStatement();){
                statement.execute("CREATE TABLE IF NOT EXISTS USERS ("+
                        "first_name varchar NOT NULL,"+
                        "last_name varchar NOT NULL,"+
                        "age number(3) NOT NULL,"+
                        "address varchar NOT NULL,"+
                        "id varchar PRIMARY KEY AUTO_INCREMENT,"+
                        "card_id varchar"+
                        ");"+
                        "CREATE TABLE IF NOT EXISTS Books ("+
                        "id number PRIMARY KEY AUTO_INCREMENT,"+
                        "author varchar NOT NULL,"+
                        "code varchar NOT NULL,"+
                        "title varchar NOT NULL,"+
                        "pagesCount NUMBER(6),"+
                        "category number,"+
                        "card_id varchar,"+
                        "date_from date,"+
                        "date_to date"+
                        ");"+
                        "CREATE TABLE IF NOT EXISTS Cards ("+
                        "id varchar PRIMARY KEY AUTO_INCREMENT,"+
                        "library_id varchar"+
                        ");"+
                        "CREATE TABLE IF NOT EXISTS Libraries ("+
                        "id NUMBER PRIMARY KEY AUTO_INCREMENT,"+
                        "address varchar NOT NULL,"+
                        "name varchar NOT NULL"+
                        ");"
                );
            }catch(SQLException ex){
                throw new IllegalStateException(ex);
            }
        }catch(SQLException e){
            throw new IllegalStateException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello!");
        connect();

        Book bookOne = new Book("Tim_Peake", "0", "Zapytaj_astonautę", 261, CategoriesEnum.Categories.Astronomia);
        System.out.println(bookOne.toString());

        User usr = new User("Marek", "Marecki", 999, "ul. Lwowska 12 15-676 Lwów", 1);
        System.out.println(usr.toString());

        Book bookTwo = new Book("J.R.R Tolkien", "1", "Władca pierścieni", 896, CategoriesEnum.Categories.Fantastyka);
        System.out.println(bookTwo.toString());

        ArrayList<Book> book_list = new ArrayList<Book>();
        book_list.add(bookOne);
        book_list.add(bookTwo);
        Card card1 = new Card(1, book_list, usr);
        System.out.println(card1.toString());

        Library biblioteka = new Library("ul Spokojna 14 23-976 Monachium", "Słoneczna Biblioteka");
        biblioteka.addBook(bookOne);
        biblioteka.addBook(bookTwo);
        biblioteka.addUser(usr);
        biblioteka.addCard(card1);
        System.out.println(biblioteka.toString());
    }
}
