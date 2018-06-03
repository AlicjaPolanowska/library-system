import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");

        Book bookOne = new Book ("Tim_Peake", "0", "Zapytaj_astonautę", 261, CategoriesEnum.Categories.Astronomia);
        System.out.println(bookOne.toString());

        User usr = new User("Marek", "Marecki", 999, "ul. Lwowska 12 15-676 Lwów",1);
        System.out.println(usr.toString());

        Book bookTwo = new Book ("J.R.R Tolkien", "1", "Władca pierścieni", 896, CategoriesEnum.Categories.Fantastyka);
        System.out.println(bookTwo.toString());

        ArrayList<Book> book_list = new ArrayList<Book>();
        book_list.add(bookOne);
        book_list.add(bookTwo);
        Card card1 = new Card(1, book_list,usr);
        System.out.println(card1.toString());

    }
}
