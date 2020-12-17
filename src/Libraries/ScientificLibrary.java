package Libraries;

import Exceptions.*;
import Lists.*;

public class ScientificLibrary {

    private int bookQuantityArr[];
    private BidirectionalList hallList;

    public ScientificLibrary(int hallQuantity, int bookQuantityArr[]) {
        this.bookQuantityArr = bookQuantityArr;
        this.hallList = new BidirectionalList();
        for (int i = 0; i < hallQuantity; i++) {
            this.hallList.addAt(i, new ScientificLibraryHall("Не определено", 1));
        }
        this.hallList.setQuantity(hallQuantity);
    }

    public ScientificLibrary(BidirectionalList hallList) {
        this.hallList = hallList;
    }

    public int getLibraryBookQuantity() {
        int globalBookQuantity = 0;
        for (int i = 0; i < getHallQuantity(); i++) {
            globalBookQuantity += getHallNumber(i).getBookQuantity();
        }
        return globalBookQuantity;
    }

    public double getLibraryBookPrice() {
        double globalBookPrice = 0;
        for (int i = 0; i < getHallQuantity(); i++) {
            for (int j = 0; j < getHallNumber(i).getBookQuantity(); j++) {
                globalBookPrice += getHallNumber(i).getBookListPrice(j);
            }
        }
        return globalBookPrice;
    }

    public ScientificLibraryHall getHallNumber(int n) {
        if (n < 0 || n >= getHallQuantity()) {
            throw new HallIndexOutOfBoundsException("Зала с номером " + n + " не существует");
        } else {
            return hallList.getElemData(n);
        }
    }

    public int getHallQuantity() {
        return hallList.howMany();
    }

    public ScientificBook getBookNumberFromLibrary(int number) {
        int book;
        int hall;
        int bookQuantity = getHallNumber(0).getBookQuantity();
        if (number <= bookQuantity) {
            hall = 1;
            book = number;
        }
        if (number % bookQuantity == 0) {
            hall = (number / bookQuantity) - 1;
            book = number - bookQuantity * hall;
        } else {
            hall = (number / bookQuantity);
            book = number - bookQuantity * hall;
        }
        if ((hall < 0 || hall >= getHallQuantity()) || (book < 0 || book >= bookQuantity)) {
            throw new HallIndexOutOfBoundsException("Книги с номером " + number + " нет в библиотеке");
        } else {
        return getHallNumber(hall).getBookNumber(book - 1);
        }
    }

    public void ShowAllHallsNames() {
        for (int i = 0; i < getHallQuantity(); i++) {
            System.out.println("В зале " + "\''" + getHallNumber(i).getHallName() + "\''" + " " + getHallNumber(i).getBookQuantity() + " книг(и)" + "\n");
        }
    }

    public void HallReplacement(int n, ScientificLibraryHall hall) {
        if (n < 0 || n >= getHallQuantity()) {
            throw new HallIndexOutOfBoundsException("Зала с номером " + n + " не существует");
        } else {
        hallList.addAt(n, hall);
        hallList.removeAt(n + 1);
        }
    }

    public void AddBookToLibrary(int number, ScientificBook book) {
        int bookN;
        int hall;
        int bookQuantity = getHallNumber(0).getBookQuantity();
        if (number <= bookQuantity) {
            hall = 1;
            bookN = number;
        }
        if (number % bookQuantity == 0) {
            hall = (number / bookQuantity) - 1;
            bookN = number - bookQuantity * hall;
        } else {
            hall = (number / bookQuantity);
            bookN = number - bookQuantity * hall;
        }
        if ((hall < 0 || hall >= getHallQuantity()) || (bookN < 0 || bookN >= bookQuantity  + 1)) {
            throw new HallIndexOutOfBoundsException("Некорректный ввод данных");
        } else {
        getHallNumber(hall).AddBookToHall(book, bookN);
        }
    }

    public void RemoveBookFromLibrary(int number) {
        int bookN;
        int hall;
        int bookQuantity = getHallNumber(0).getBookQuantity();
        if (number <= bookQuantity) {
            hall = 1;
            bookN = number;
        }
        if (number % bookQuantity == 0) {
            hall = (number / bookQuantity) - 1;
            bookN = number - bookQuantity * hall;
        } else {
            hall = (number / bookQuantity);
            bookN = number - bookQuantity * hall;
        }
        if ((hall < 0 || hall >= getHallQuantity()) || (bookN < 0 || bookN >= bookQuantity)) {
            throw new HallIndexOutOfBoundsException("Книги с номером " + number + " нет в библиотеке");
        } else {
        getHallNumber(hall).RemoveBookFromHall(bookN);
    }
    }

    public ScientificBook getWholeLibraryBestBook() {
        double maxPrice = 0;
        int index = 0;
        for (int i = 0; i < getHallQuantity(); i++) {
            if (maxPrice < getHallNumber(i).getBestBook().getPrice()) {
                maxPrice = getHallNumber(i).getBestBook().getPrice();
                index = i;
            }
        }
        return getHallNumber(index).getBestBook();
    }
}
