package Libraries;

import Exceptions.*;
import Lists.*;

public class ScientificLibraryHall {

    private String hallname;
    private List bookList;

    public ScientificLibraryHall(String hallname, int bookQuantity) {
        if (bookQuantity <= 0) {
            throw new InvalidBookCountException("Количество книг не может быть отрицательным");
        }
        else {
        this.hallname = hallname;
        this.bookList = new List();
        for (int i = 0; i < bookQuantity; i++) {

            this.bookList.add(new ScientificBook());

        }
        this.bookList.setQuantity(bookQuantity);
        }
    }

    public ScientificLibraryHall(String hallname, List bookList) {
        this.hallname = hallname;
        this.bookList = bookList;

    }

    public void setHallName(String hallName) {
        this.hallname = hallName;
    }

    public void setBookList(List bookList) {
        this.bookList = bookList;
    }

    public ScientificBook getBookNumber(int n) {
        if (n < 0 || n >= bookList.howMany()) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        return bookList.getElemData(n);
        }
    }

    public String getBookListAuthor(int n) {
        if (n < 0 || n >= bookList.howMany()) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        return getBookNumber(n).getAuthor();
        }
    }

    public String getBookListTitle(int n) {
        if (n < 0 || n >= bookList.howMany()) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        return getBookNumber(n).getTitle();
        }
    }

    public double getBookListPrice(int n) {
        if (n < 0 || n >= bookList.howMany()) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        return getBookNumber(n).getPrice();
        }
    }

    public int getBookListYear(int n) {
        if (n < 0 || n >= bookList.howMany()) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        return getBookNumber(n).getYear();
        }
    }

    public double getBookListSCI(int n) {
        if (n < 0 || n >= bookList.howMany()) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        return getBookNumber(n).getSCI();
        }
    }

    public String getHallName() {
        return hallname;
    }

    public int getBookQuantity() {
        return bookList.howMany();
    }

    public void print() {
        bookList.print();
    }

    public void showAllBookTitles() {
        for (int i = 0; i < bookList.howMany(); i++) {
            System.out.println(bookList.getElemData(i).getTitle() + "\n");
        }
        System.out.println("\n");
    }

    public double getFullCost() {
        double fullCost = 0;
        for (int i = 0; i < bookList.howMany(); i++) {
            fullCost += bookList.getElemData(i).getPrice();
        }
        return fullCost;
    }

    public void SortPriceHall() {
        double temp;
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < bookList.howMany(); i++) {
                if (bookList.getElemData(i).getPrice() > bookList.getElemData(i - 1).getPrice()) {
                    temp = bookList.getElemData(i - 1).getPrice();
                    bookList.getElemData(i - 1).setPrice(bookList.getElemData(i).getPrice());
                    bookList.getElemData(i).setPrice(temp);
                    needIteration = true;
                }
            }
        }
    }

    public void makeAuthorChanges(int n, String author) {
        if (n < 0 || n >= bookList.howMany()) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        bookList.getElemData(n).setAuthor(author);
        }
    }

    public void makeTitleChanges(int n, String title) {
        if (n < 0 || n >= bookList.howMany()) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        bookList.getElemData(n).setTitle(title);
        }
    }

    public void makePriceChanges(int n, double price) {
        if (n < 0 || n >= bookList.howMany()) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
            if (price <= 0) {
            throw new InvalidBookPriceException("Цена книги не может быть отрицательной");
        } else {
        bookList.getElemData(n).setPrice(price);
        }
        }
    }

    public void makeYearChanges(int n, int year) {
        if (n < 0 || n >= bookList.howMany()) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        bookList.getElemData(n).setYear(year);
        }
    }

    public void makeSCIChanges(int n, double SCI) {
        if (n < 0 || n >= bookList.howMany()) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        bookList.getElemData(n).setSCI(SCI);
        }
    }

    public void AddBookToHall(ScientificBook book, int n) {
        if (n < 0 || n >= bookList.howMany() + 1) {
            throw new BookIndexOutOfBoundsException("Некорректный ввод данных");
        } else {
        bookList.addAt(n, book);
        }
    }

    public void RemoveBookFromHall(int n) {
        if (n < 0 || n >= bookList.howMany()) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        bookList.remove(n);
        }
    }

    public ScientificBook getBestBook() {
        double maxPrice = 0;
        int index = 0;
        for (int i = 0; i < bookList.howMany(); i++) {
            if (maxPrice < bookList.getElemData(i).getPrice()) {
                maxPrice = bookList.getElemData(i).getPrice();
                index = i;
            }
        }
        return bookList.getElemData(index);
    }
}
