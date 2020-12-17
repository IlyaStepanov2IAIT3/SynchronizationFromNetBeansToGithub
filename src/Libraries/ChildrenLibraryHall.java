package Libraries;

import Exceptions.*;


public class ChildrenLibraryHall {

    private String hallName;
    private ChildrenBook bookArr[];

    public ChildrenLibraryHall(String hallName, int bookQuantity) {
        if (bookQuantity <= 0) {
            throw new InvalidBookCountException("Количество книг не может быть отрицательным");
        }
        else {
        this.hallName = hallName;
        this.bookArr = new ChildrenBook[bookQuantity];
        for (int i = 0; i < bookQuantity; i++) {
            this.bookArr[i] = new ChildrenBook();
        }
        }
    }

    public ChildrenLibraryHall(String hallName, ChildrenBook bookArr[]) {
        this.hallName = hallName;
        this.bookArr = bookArr;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public void setBookArr(int bookQuantity) {
        if (bookQuantity <= 0) {
            throw new InvalidBookCountException("Количество книг не может быть отрицательным");
        }
        else {
        for (int i = 0; i < bookQuantity; i++) {
            this.bookArr[i] = new ChildrenBook();
        }
        }
    }

    public ChildrenBook getBookNumber(int n) {
        if (n < 0 || n >= bookArr.length) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
            return bookArr[n];
        }
    }

    public String getBookArrAuthor(int n) {
        if (n < 0 || n >= bookArr.length) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        return getBookNumber(n).getAuthor();
        }
    }

    public String getBookArrTitle(int n) {
        if (n < 0 || n >= bookArr.length) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        return getBookNumber(n).getTitle();
        }
    }

    public double getBookArrPrice(int n) {
        if (n < 0 || n >= bookArr.length) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        return getBookNumber(n).getPrice();
        }
    }

    public int getBookArrYear(int n) {
        if (n < 0 || n >= bookArr.length) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        return getBookNumber(n).getYear();
        }
    }

    public int getBookArrAge(int n) {
        if (n < 0 || n >= bookArr.length) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        return getBookNumber(n).getAge();
        }
    }

    public String getHallName() {
        return hallName;
    }

    public int getBookQuantity() {
        return bookArr.length;
    }

    public void printBook() {
        for (int i = 0; i < bookArr.length; i++) {
            System.out.println(bookArr[i].getAuthor() + " | " + bookArr[i].getTitle() + " | " + bookArr[i].getPrice() + " | " + bookArr[i].getYear() + " | " + bookArr[i].getAge() + "\n");
        }
    }

    public void showAllBookTitles() {
        for (int i = 0; i < bookArr.length; i++) {
            System.out.println(bookArr[i].getTitle() + "\n");
        }
        System.out.println("\n");
    }

    public double getFullCost() {
        double fullCost = 0;
        for (int i = 0; i < bookArr.length; i++) {
            fullCost += bookArr[i].getPrice();
        }
        return fullCost;
    }

    public void SortPriceHall() {
        double temp;
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < bookArr.length; i++) {
                if (bookArr[i].getPrice() > bookArr[i - 1].getPrice()) {
                    temp = bookArr[i - 1].getPrice();
                    bookArr[i - 1].setPrice(bookArr[i].getPrice());
                    bookArr[i].setPrice(temp);
                    needIteration = true;
                }
            }
        }
    }

    public void makeAuthorChanges(int n, String author) {
        if (n < 0 || n >= bookArr.length) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        getBookNumber(n).setAuthor(author);
        }
    }

    public void makeTitleChanges(int n, String title) {
        if (n < 0 || n >= bookArr.length) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        getBookNumber(n).setTitle(title);
        }
    }

    public void makePriceChanges(int n, double price) {
        if (n < 0 || n >= bookArr.length) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
            if (price <= 0) {
                throw new InvalidBookPriceException("Цена книги не может быть отрицательной");
            } else {
                getBookNumber(n).setPrice(price);
            }
        }
    }

    public void makeYearChanges(int n, int year) {
        if (n < 0 || n >= bookArr.length) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        getBookNumber(n).setYear(year);
        }
    }

    public void makeAgeChanges(int n, int age) {
        if (n < 0 || n >= bookArr.length) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        getBookNumber(n).setAge(age);
        }
    }

    public void AddBookToHall(ChildrenBook book, int n) {
        if (n < 0 || n >= bookArr.length + 1) {
            throw new BookIndexOutOfBoundsException("Некорректный ввод данных");
        } else {
        ChildrenBook bookArr[] = new ChildrenBook[this.bookArr.length + 1];
        for (int i = 0; i < n - 1; i++) {
            bookArr[i] = this.bookArr[i];
        }
        bookArr[n - 1] = book;
        for (int i = n; i < this.bookArr.length + 1; i++) {
            bookArr[i] = this.bookArr[i - 1];
        }
        this.bookArr = bookArr;
        }
    }

    public void RemoveBookFromHall(int n) {
        if (n < 0 || n >= bookArr.length) {
            throw new BookIndexOutOfBoundsException("Книги с номером " + n + " не существует.");
        } else {
        ChildrenBook bookArr[] = new ChildrenBook[this.bookArr.length - 1];
        for (int i = 0; i < n - 1; i++) {
            bookArr[i] = this.bookArr[i];
        }
        for (int i = n - 1; i < this.bookArr.length - 1; i++) {
            bookArr[i] = this.bookArr[i + 1];
        }
        this.bookArr = bookArr;
        }
    }

    public ChildrenBook getBestBook() {
        double maxPrice = 0;
        int index = 0;
        for (int i = 0; i < bookArr.length; i++) {
            if (maxPrice < bookArr[i].getPrice()) {
                maxPrice = bookArr[i].getPrice();
                index = i;
            }
        }
        return bookArr[index];
    }
}
