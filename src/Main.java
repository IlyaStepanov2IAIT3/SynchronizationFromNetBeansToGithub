
import Lists.*;
import Libraries.*;

public class Main {

    public static void main(String[] args) {

        ScientificBook scientificBook1 = new ScientificBook("Стивен Хокинг", "Краткая история времени", 565.33, 1988, 10.2);
        ScientificBook scientificBook2 = new ScientificBook("Сильченко О.К.", "Происхождение и эволюция галактик", 495.95, 2017, 1.7);
        List astronomy = new List();
        astronomy.add(scientificBook1);
        astronomy.add(scientificBook2);
        ScientificLibraryHall AstronomyHall = new ScientificLibraryHall("Раздел: Астрономия", astronomy);
        AstronomyHall.getBookNumber(-5).printBook();
        /*ScientificBook scientificBook3 = new ScientificBook("Ф.Ю. Зигель", "Астрономическая мозаика", 535.99, 1987, 5);
        ScientificBook scientificBook4 = new ScientificBook("Сиддхартха Мукерджи", "Царь всех болезней. Биография рака", 550.55, 2010, 12.3);
        ScientificBook scientificBook5 = new ScientificBook("Клиффорд Пиковер", "Великая медицина", 2451.99, 2010, 15);
        ScientificBook scientificBook6 = new ScientificBook("Джексон Уильям", "Клиническая медицина", 1645.98, 2009, 15);

        List astronomy = new List();
        astronomy.add(scientificBook1);
        astronomy.add(scientificBook2);
        astronomy.add(scientificBook3);

        List medicine = new List();
        medicine.add(scientificBook4);
        medicine.add(scientificBook5);
        medicine.add(scientificBook6);

        ScientificLibraryHall AstronomyHall = new ScientificLibraryHall("Раздел: Астрономия", astronomy);
        ScientificLibraryHall MedicineHall = new ScientificLibraryHall("Раздел: Медицина", medicine);
        ScientificLibraryHall MathHall = new ScientificLibraryHall("Раздел: Математика", 3);

        MathHall.makeAuthorChanges(0, "Герберт Роббинс");
        MathHall.makeTitleChanges(0, "Что такое математика?");
        MathHall.makePriceChanges(0, 693.99);
        MathHall.makeYearChanges(0, 1941);
        MathHall.makeSCIChanges(0, 15);

        MathHall.makeAuthorChanges(1, "Владимир Успенский");
        MathHall.makeTitleChanges(1, "Апология математики");
        MathHall.makePriceChanges(1, 345.95);
        MathHall.makeYearChanges(1, 2010);
        MathHall.makeSCIChanges(1, 4.8);

        MathHall.makeAuthorChanges(2, "Григорий Фихтенгольц");
        MathHall.makeTitleChanges(2, "Курс дифференциального и интегрального вычисления");
        MathHall.makePriceChanges(2, 1100);
        MathHall.makeYearChanges(2, 1947);
        MathHall.makeSCIChanges(2, 3.6);

        BidirectionalList scientificHalls = new BidirectionalList();

        scientificHalls.addAt(0, AstronomyHall);
        scientificHalls.addAt(1, MedicineHall);
        scientificHalls.addAt(2, MathHall);

        ScientificLibrary scientificLibrary = new ScientificLibrary(scientificHalls);

        for (int i = 0; i < scientificLibrary.getHallQuantity(); i++) {
            System.out.println("\t" + scientificLibrary.getHallNumber(i).getHallName());
            scientificLibrary.getHallNumber(i).print();
        }

        System.out.println("\tНазвания всех книг в библиотеке");
        for (int i = 0; i < scientificLibrary.getHallQuantity(); i++) {
            System.out.println("\t" + scientificLibrary.getHallNumber(i).getHallName());
            scientificLibrary.getHallNumber(i).showAllBookTitles();
        }

        System.out.println("\tСтоимость всех кинг в библиотеке ");
        for (int i = 0; i < scientificLibrary.getHallQuantity(); i++) {
            System.out.print("Зал: " + scientificLibrary.getHallNumber(i).getHallName() + " - ");
            System.out.println(scientificLibrary.getHallNumber(i).getFullCost() + "\n");
        }

        System.out.println("\tСортировка по убыванию цены");
        for (int i = 0; i < scientificLibrary.getHallQuantity(); i++) {
            scientificLibrary.getHallNumber(i).SortPriceHall();
        }
        for (int i = 0; i < scientificLibrary.getHallQuantity(); i++) {
            System.out.println("\t" + scientificLibrary.getHallNumber(i).getHallName());
            scientificLibrary.getHallNumber(i).print();
        }

        ScientificBook scientificBook10 = new ScientificBook("Брайан Рэндольф Грин", "Ткань космоса", 1158.99, 2003, 5.9);
        ScientificBook scientificBook11 = new ScientificBook("Никита Жуков", "Модицина. Encyclopedia Pathologica", 653.90, 2020, 5.9);
        ScientificBook scientificBook12 = new ScientificBook("Саймон Сингх", "Последняя теорема Ферма", 522.90, 1997, 6.2);

        System.out.println("\tРасширение каждого зала на одну книгу");
        scientificLibrary.getHallNumber(0).AddBookToHall(scientificBook10, 0);
        scientificLibrary.getHallNumber(1).AddBookToHall(scientificBook11, 1);
        scientificLibrary.getHallNumber(2).AddBookToHall(scientificBook12, 2);
        for (int i = 0; i < scientificLibrary.getHallQuantity(); i++) {
            System.out.println("\t" + scientificLibrary.getHallNumber(i).getHallName());
            scientificLibrary.getHallNumber(i).print();
        }

        System.out.println("\tУдаление одной книги из каждого зала");
        scientificLibrary.getHallNumber(0).RemoveBookFromHall(2);
        scientificLibrary.getHallNumber(1).RemoveBookFromHall(1);
        scientificLibrary.getHallNumber(2).RemoveBookFromHall(0);
        for (int i = 0; i < scientificLibrary.getHallQuantity(); i++) {
            System.out.println("\t" + scientificLibrary.getHallNumber(i).getHallName());
            scientificLibrary.getHallNumber(i).print();
        }

        System.out.println("\tСамая дорогая книга в каждом из залов");
        for (int i = 0; i < scientificLibrary.getHallQuantity(); i++) {
            System.out.println("\t" + scientificLibrary.getHallNumber(i).getHallName());
            scientificLibrary.getHallNumber(i).getBestBook().printBook();
        }

        System.out.println("Количество залов в библиотеке: " + scientificLibrary.getHallQuantity());

        System.out.println("Количество всех книг в библиотеке: " + scientificLibrary.getLibraryBookQuantity());

        System.out.println("Стоимость всех книг в библиотеке: " + scientificLibrary.getLibraryBookPrice());

        System.out.println("Количество книг по залам: ");
        scientificLibrary.ShowAllHallsNames();

        System.out.println("Самая дорогая книга в библиотеке: ");
        scientificLibrary.getWholeLibraryBestBook().printBook();

        /*ChildrenBook[] setA = new ChildrenBook[5];
        for (int i = 0; i < setA.length; i++) {
            setA[i] = new ChildrenBook();
        }

        setA[0].setAuthor("Виктор Драгунский");
        setA[0].setTitle("Денискины рассказы");
        setA[0].setPrice(279.98);
        setA[0].setYear(1959);
        setA[0].setAge(8);

        setA[1].setAuthor("Алексей Толстой");
        setA[1].setTitle("Золотой ключик");
        setA[1].setPrice(379.98);
        setA[1].setYear(1936);
        setA[1].setAge(8);

        setA[2].setAuthor("Джон Р.Р. Толкин");
        setA[2].setTitle("Хоббит, или Туда и Обратно");
        setA[2].setPrice(675.98);
        setA[2].setYear(1937);
        setA[2].setAge(8);

        setA[3].setAuthor("Марк Твен");
        setA[3].setTitle("Сборник рассказов");
        setA[3].setPrice(789.98);
        setA[3].setYear(1967);
        setA[3].setAge(8);

        setA[4].setAuthor("Льюис Кэрролл");
        setA[4].setTitle("Алиса в Стране чудес");
        setA[4].setPrice(319.98);
        setA[4].setYear(1865);
        setA[4].setAge(8);*/

       

        ChildrenLibraryHall hallA = new ChildrenLibraryHall("10+", 5);
        hallA.getBookNumber(3).printBook();
        /*ChildrenLibraryHall hallB = new ChildrenLibraryHall("8+", setA);

        ChildrenLibraryHall[] halls = new ChildrenLibraryHall[3];
        for (int i = 0; i < halls.length; i++) {
            halls[i] = new ChildrenLibraryHall("10+", 5);
        }
        for (int i = 0; i < halls.length; i++) {
            halls[i].setBookArr(5);
        }
        ChildrenLibrary childrenLibrary = new ChildrenLibrary(halls);

        childrenLibrary.HallReplacement(1, hallA);
        childrenLibrary.HallReplacement(2, hallB);

        hallA.makeAuthorChanges(0, "Николай Носов");
        hallA.makeTitleChanges(0, "Фантазёры");
        hallA.makePriceChanges(0, 350.99);
        hallA.makeYearChanges(0, 1939);
        hallA.makeAgeChanges(0, 10);

        hallA.makeAuthorChanges(1, "Александр Волков");
        hallA.makeTitleChanges(1, "Сказочные повести");
        hallA.makePriceChanges(1, 450.99);
        hallA.makeYearChanges(1, 1961);
        hallA.makeAgeChanges(1, 10);

        hallA.makeAuthorChanges(2, "Валерий Медведев");
        hallA.makeTitleChanges(2, "Баранкин, будь человеком!");
        hallA.makePriceChanges(2, 387.49);
        hallA.makeYearChanges(2, 1963);
        hallA.makeAgeChanges(2, 10);

        hallA.makeAuthorChanges(3, "Жюль Верн");
        hallA.makeTitleChanges(3, "Дети капитана Гранта");
        hallA.makePriceChanges(3, 239.99);
        hallA.makeYearChanges(3, 1868);
        hallA.makeAgeChanges(3, 10);

        hallA.makeAuthorChanges(4, "Даниэль Дефо");
        hallA.makeTitleChanges(4, "Робинзон Крузо");
        hallA.makePriceChanges(4, 532.94);
        hallA.makeYearChanges(4, 1719);
        hallA.makeAgeChanges(4, 10);

        halls[2].makeAuthorChanges(0, "Николай Носов");
        halls[2].makeTitleChanges(0, "Незнайка на Луне");
        halls[2].makePriceChanges(0, 253.99);
        halls[2].makeYearChanges(0, 1964);
        halls[2].makeAgeChanges(0, 10);

        halls[2].makeAuthorChanges(1, "Роберт Льюис Стивенсон");
        halls[2].makeTitleChanges(1, "Остров Сокровищ");
        halls[2].makePriceChanges(1, 349.99);
        halls[2].makeYearChanges(1, 1883);
        halls[2].makeAgeChanges(1, 10);

        halls[2].makeAuthorChanges(2, "Ганс Христиан Андерсон");
        halls[2].makeTitleChanges(2, "Сказки");
        halls[2].makePriceChanges(2, 487.49);
        halls[2].makeYearChanges(2, 1839);
        halls[2].makeAgeChanges(2, 10);

        halls[2].makeAuthorChanges(3, "Александр Пушкин");
        halls[2].makeTitleChanges(3, "Сказки о рыбаке и рыбке");
        halls[2].makePriceChanges(3, 339.99);
        halls[2].makeYearChanges(3, 1833);
        halls[2].makeAgeChanges(3, 10);

        halls[2].makeAuthorChanges(4, "Антон Чехов");
        halls[2].makeTitleChanges(4, "Каштанка");
        halls[2].makePriceChanges(4, 478.83);
        halls[2].makeYearChanges(4, 1887);
        halls[2].makeAgeChanges(4, 10);

        
        /*System.out.println("\n                     Названия всех книг в библиотеке");
        for (int i = 0; i < childrenLibrary.getHallQuantity(); i++) {
            System.out.println("     Зал " + i);
            childrenLibrary.getHallNumber(i).showAllBookTitles();
        }
        System.out.println("  Стоимость всех кинг в библиотеке ");
        for (int i = 0; i < childrenLibrary.getHallQuantity(); i++) {
            System.out.print("Зал " + i + " - ");
            System.out.println(childrenLibrary.getHallNumber(i).getFullCost() + "\n");
        }

        System.out.println("                     Сортировка по убыванию цены");
        for (int i = 0; i < childrenLibrary.getHallQuantity(); i++) {
            childrenLibrary.getHallNumber(i).SortPriceHall();
        }
        for (int i = 0; i < childrenLibrary.getHallQuantity(); i++) {
            System.out.println("                                Зал " + i);
            System.out.println("      Автор   |  Название |   Цена | Год  | Рекомендуемый возраст ");
            childrenLibrary.getHallNumber(i).printBook();
        }

        ChildrenBook newBook1 = new ChildrenBook("Николай Лесков", "Левша", 350.30, 1881, 8);
        ChildrenBook newBook2 = new ChildrenBook("Марк Твен", "Принц и Нищий", 299.99, 1880, 8);
        ChildrenBook newBook3 = new ChildrenBook("Валентин Распутин", "Уроки французского", 399.99, 1973, 8);

        System.out.println("                 Расширение каждого зала на одну книгу");

        childrenLibrary.getHallNumber(0).AddBookToHall(newBook1, 3);
        childrenLibrary.getHallNumber(1).AddBookToHall(newBook2, 4);
        childrenLibrary.getHallNumber(2).AddBookToHall(newBook3, 5);

        for (int i = 0; i < childrenLibrary.getHallQuantity(); i++) {
            System.out.println("                                Зал " + i);
            System.out.println("      Автор   |  Название |   Цена | Год  | Рекомендуемый возраст ");
            childrenLibrary.getHallNumber(i).printBook();
        }

        System.out.println("                 Удаление одной книги из каждого зала");
        childrenLibrary.getHallNumber(0).RemoveBookFromHall(3);
        childrenLibrary.getHallNumber(1).RemoveBookFromHall(4);
        childrenLibrary.getHallNumber(2).RemoveBookFromHall(5);

        for (int i = 0; i < childrenLibrary.getHallQuantity(); i++) {
            System.out.println("                                Зал " + i);
            System.out.println("      Автор   |  Название |   Цена | Год  | Рекомендуемый возраст ");
            childrenLibrary.getHallNumber(i).printBook();
        }

        System.out.println("                 Самая дорогая книга в каждом из залов");
        for (int i = 0; i < childrenLibrary.getHallQuantity(); i++) {
            System.out.print("Зал " + i + ": ");
            childrenLibrary.getHallNumber(i).getBestBook().printBook();
        }

        System.out.println("Количество залов в библиотеке: " + childrenLibrary.getHallQuantity());

        System.out.println("Количество всех книг в библиотеке: " + childrenLibrary.getLibraryBookQuantity());

        System.out.println("Стоимость всех книг в библиотеке: " + childrenLibrary.getLibraryBookPrice());

        System.out.println("Количество книг по залам: ");
        childrenLibrary.ShowAllHallsNames();

        System.out.println("Самая дорогая книга в библиотеке: ");
        childrenLibrary.getWholeLibraryBestBook().printBook();*/
    }
}
