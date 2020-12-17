package Libraries;
import Exceptions.*;
public class ChildrenBook extends Book {

    private int age;

    public ChildrenBook() {
        super();
        age = 0;
    }

    public ChildrenBook(String author, int year) {
        super(author, year);
        age = 0;
    }

    public ChildrenBook(String author, String title, double price, int year, int age) {
        super(author, title, price, year);
        if (price <= 0) {
            throw new InvalidBookPriceException("Цена книги не может быть отрицательной");
        } 
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printBook() {
        System.out.println(getAuthor() + " | " + getTitle() + " | " + getPrice() + " | " + getYear() + " | " + getAge());
    }
}
