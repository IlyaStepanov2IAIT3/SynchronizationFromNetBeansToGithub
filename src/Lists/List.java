package Lists;

import Libraries.*;

public class List {

    private Item head;
    private Item top;
    private int quantity = 0;

    public List() {
        head = new Item();
        head.next = head;
    }

    public int howMany() {
        return quantity;
    }
    
    public boolean isEmpty() {
       return howMany() == 0;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Список пуст");
        } else {
            Item temp = top;
            System.out.println("Автор: " + temp.data.getAuthor());
            System.out.println("Название: " + temp.data.getTitle());
            System.out.println("Цена: " + temp.data.getPrice());
            System.out.println("Год выпуска: " + temp.data.getYear());
            System.out.println("Индекс цитирования: " + temp.data.getSCI() + "\n");
            temp = temp.next;
            while (temp != top) {
                System.out.println("Автор: " + temp.data.getAuthor());
                System.out.println("Название: " + temp.data.getTitle());
                System.out.println("Цена: " + temp.data.getPrice());
                System.out.println("Год выпуска: " + temp.data.getYear());
                System.out.println("Индекс цитирования: " + temp.data.getSCI() + "\n");
                temp = temp.next;
            }
        }
    }

    public void add(ScientificBook data) {
        Item temp = new Item(data);
        if (isEmpty()) {
            head.next = temp;
            top = head.next;
            quantity++;
        } else {
            head.next.next = temp;
            head.next = temp;
            head.next.next = top;
            quantity++;
        }
    }

    public boolean remove(int n) {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return false;
        } else {
            if (n == 0) {
                top = top.next;
                head.next.next = top;
                quantity--;
                return true;
            }
            getElem(n - 1).next = getElem(n - 1).next.next;
            quantity--;
            return true;
        }
    }

    public Item getElem(int n) {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return null;
        } else {
            if (n == 0) {
                return top;
            }
            Item temp = top;
            int i = 0;
            do {
                temp = temp.next;
                i++;
            } while (i != n && temp != top);
            if (temp == top) {
                return null;
            } else {
                return temp;
            }
        }
    }

    public ScientificBook getElemData(int n) {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return null;
        } else {
            if (n == 0) {
                return top.data;
            }
            Item temp = top;
            int i = 0;
            do {
                temp = temp.next;
                i++;
            } while (i != n && temp != top);
            if (temp == top) {
                return null;
            } else {
                return temp.data;
            }
        }
    }

    public boolean addAt(int n, ScientificBook data) {
        Item temp = new Item(data);
        if (n == quantity) {
            if (n == 0) {
                head.next = temp;
                top = head.next;
                quantity++;
            }
            if (n == 1) {
                temp.next = top.next;
                top.next = temp;
                head.next = temp;
                quantity++;
                return true;
            }
            temp.next = getElem(n - 1).next;
            getElem(n - 1).next = temp;
            head.next = temp;
            quantity++;
            return true;

        } else {
            if (n == 0) {
                temp.next = top;
                top = temp;
                head.next.next = temp;
                quantity++;
                return true;
            }
            if (n == 1) {
                temp.next = top.next;
                top.next = temp;
                quantity++;
                return true;
            }
            temp.next = getElem(n - 1).next;
            getElem(n - 1).next = temp;
            quantity++;

            return true;
        }
    }
}
