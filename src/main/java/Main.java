public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");

        Book bookOne = new Book ("Tim_Peake", "0", "Zapytaj_astonautę", 261, CategoriesEnum.Categories.Astronomia);
        System.out.println(bookOne.getCategory());
    }
}
