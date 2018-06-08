import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static void connect(){

        try(Connection connection=DriverManager.getConnection("jdbc:h2:~/my-local","sa","");){
            try(Statement statement=connection.createStatement();){
                statement.execute(//"Drop table Users; drop table Books; drop table Cards; drop table Libraries;"+
                        "CREATE TABLE IF NOT EXISTS USERS ("+
                        "first_name varchar NOT NULL,"+
                        "last_name varchar NOT NULL,"+
                        "age number(3) NOT NULL,"+
                        "address varchar NOT NULL,"+
                        "id varchar PRIMARY KEY AUTO_INCREMENT,"+
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
                        "date_to date,"+
                        "library_id number"+
                        ");"+
                        "CREATE TABLE IF NOT EXISTS Cards ("+
                        "id varchar PRIMARY KEY AUTO_INCREMENT,"+
                        "user_id number, "+
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

        Library biblioteka = new Library("ul Spokojna 14 23-976 Monachium", "Słoneczna Biblioteka");


        Book bookOne = new Book("Tim_Peake", "0", "Zapytaj_astonautę", 261, CategoriesEnum.Categories.Astronomia, biblioteka);
        System.out.println(bookOne.toString());

        User usr = new User("Marek", "Marecki", 999, "ul. Lwowska 12 15-676 Lwów");
        User usr1 = new User("MASrcin", "Mek", 69, "ul. Lublin 12 Lwów");
        System.out.println(usr.toString());

        Book bookTwo = new Book("J.R.R Tolkien", "1", "Władca pierścieni", 896, CategoriesEnum.Categories.Fantastyka, biblioteka);
        System.out.println(bookTwo.toString());

        Card card1 = new Card(usr,biblioteka);
        System.out.println(card1.toString());

        //Library biblioteka = new Library("ul Spokojna 14 23-976 Monachium", "Słoneczna Biblioteka");
      //  biblioteka.addBook(bookOne);
      //  biblioteka.addBook(bookTwo);
        biblioteka.addUser(usr);
        biblioteka.addCard(card1);
        System.out.println(biblioteka.toString());

        Inserted.insBook(bookOne);
        Inserted.insBook(bookTwo);
        Inserted.insBook(bookTwo);

        Inserted.insUser(usr);
        Inserted.insUser(usr1);

        Inserted.insCard(card1);

        User u = Selected.getUser(2);
        System.out.println(u.toString());

        Card cardSel = Selected.getCard(1);
        System.out.println(cardSel.toString());

    }
}
