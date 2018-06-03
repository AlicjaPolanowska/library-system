public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");

        Book bookOne = new Book ("Tim_Peake", "0", "Zapytaj_astonautę", 261, CategoriesEnum.Categories.Astronomia);
        System.out.println(bookOne.toString());

        User usr = new User("Marek", "Marecki", 999, "ul. Lwowska 12 15-676 Lwów",1);
        System.out.println(usr.toString());
    }
}
