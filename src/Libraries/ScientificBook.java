package Libraries;

import Exceptions.*;

public class ScientificBook extends Book {

    private double SCI;

    public ScientificBook() {
        super();
        SCI = 0.0;
    }

    public ScientificBook(String author, int year) {
        super(author, year);
        SCI = 0.0;
    }

    public ScientificBook(String author, String title, double price, int year, double SCI) {
        super(author, title, price, year);
        if (price <= 0) {
            throw new InvalidBookPriceException("Цена книги не может быть отрицательной");
        } 
        this.SCI = SCI;
    }

    public void setSCI(double SCI) {
        this.SCI = SCI;
    }

    public double getSCI() {
        return SCI;
    }

    public void printBook() {
        System.out.println("Автор: " + getAuthor());
        System.out.println("Название: " + getTitle());
        System.out.println("Цена: " + getPrice());
        System.out.println("Год выпуска: " + getYear());
        System.out.println("Индекс цитирования: " + getSCI() + "\n");
    }
}
