package Libraries;
import Exceptions.*;
public class Book {

    private String author;
    private String title;
    private double price;
    private int year;

    public Book() {
        author = "Не определено";
        title = "Не определено";
        price = 0.0;
        year = 0;
    }

    public Book(String author, int year) {
        this();
        this.author = author;
        this.year = year;
    }

    public Book(String author, String title, double price, int year) {
        this.author = author;
        this.title = title;
        if (price <= 0) {
            throw new InvalidBookPriceException("Цена книги не может быть отрицательной");
        } else {
            this.price = price;
        }
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new InvalidBookPriceException("Цена книги не может быть отрицательной");
        } else {
        this.price = price;
        }
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }
}
