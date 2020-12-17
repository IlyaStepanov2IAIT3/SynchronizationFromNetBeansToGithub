package Libraries;
import Exceptions.*;
public class ChildrenLibrary {

    private int bookQuantityArr[];
    private ChildrenLibraryHall hallArr[];

    public ChildrenLibrary(int hallQuantity, int bookQuantityArr[]) {

        this.bookQuantityArr = bookQuantityArr;
        for (int i = 0; i < hallQuantity; i++) {
            this.hallArr[i] = new ChildrenLibraryHall("Не определено", 10);
        }
    }

    public ChildrenLibrary(ChildrenLibraryHall hallArr[]) {
        this.hallArr = hallArr;
    }

    public int getLibraryBookQuantity() {
        int globalBookQuantity = 0;
        for (int i = 0; i < hallArr.length; i++) {
            globalBookQuantity += hallArr[i].getBookQuantity();
        }
        return globalBookQuantity;
    }

    public double getLibraryBookPrice() {
        double globalBookPrice = 0;
        for (int i = 0; i < hallArr.length; i++) {
            for (int j = 0; j < hallArr[i].getBookQuantity(); j++) {
                globalBookPrice += hallArr[i].getBookArrPrice(j);
            }
        }
        return globalBookPrice;
    }

    public ChildrenLibraryHall getHallNumber(int n) {
        if (n < 0 || n >= hallArr.length) {
            throw new HallIndexOutOfBoundsException("Зала с номером " + n + " не существует");
        } else {
            return hallArr[n];
        }
    }

    public int getHallQuantity() {
        return hallArr.length;
    }

    public ChildrenBook getBookNumberFromLibrary(int number) {
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
        if ((hall < 0 || hall >= hallArr.length) || (book < 0 || book >= bookQuantity)) {
            throw new HallIndexOutOfBoundsException("Книги с номером " + number + " нет в библиотеке");
        } else {
        return getHallNumber(hall).getBookNumber(book - 1);
        }
    }

    public void ShowAllHallsNames() {
        for (int i = 0; i < hallArr.length; i++) {
            System.out.println("В зале " + "\''" + hallArr[i].getHallName() + "\''" + " " + hallArr[i].getBookQuantity() + " книг(и)" + "\n");
        }
    }

    public void HallReplacement(int n, ChildrenLibraryHall hall) {
        if (n < 0 || n >= hallArr.length) {
            throw new HallIndexOutOfBoundsException("Зала с номером " + n + " не существует");
        } else {
        n--;
        hallArr[n] = hall;
        }
    }

    public void AddBookToLibrary(int number, ChildrenBook book) {
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
        if ((hall < 0 || hall >= hallArr.length) || (bookN < 0 || bookN >= bookQuantity  + 1)) {
            throw new HallIndexOutOfBoundsException("Некорректный ввод данных");
        } else {
        hallArr[hall].AddBookToHall(book, bookN);
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
        if ((hall < 0 || hall >= hallArr.length) || (bookN < 0 || bookN >= bookQuantity)) {
            throw new HallIndexOutOfBoundsException("Книги с номером " + number + " нет в библиотеке");
        } else {
        hallArr[hall].RemoveBookFromHall(bookN);
        }
    }

    public ChildrenBook getWholeLibraryBestBook() {
        double maxPrice = 0;
        int index = 0;
        for (int i = 0; i < hallArr.length; i++) {
            if (maxPrice < hallArr[i].getBestBook().getPrice()) {
                maxPrice = hallArr[i].getBestBook().getPrice();
                index = i;
            }
        }
        return hallArr[index].getBestBook();
    }

}
