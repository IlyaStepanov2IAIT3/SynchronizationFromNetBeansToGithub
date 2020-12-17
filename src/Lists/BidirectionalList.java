package Lists;

import Libraries.*;

public class BidirectionalList {

    private Item2 head;
    private Item2 tail;
    private int quantity = 0;

    public BidirectionalList() {
        head = new Item2();
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

    public Item2 getElem(int n) {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return null;
        } else {
            if (n == 0) {
                return tail;
            }
            Item2 temp = tail;
            int i = 0;
            do {
                temp = temp.next;
                i++;
            } while (i != n && temp != tail);
            if (temp == tail) {
                return null;
            } else {
                return temp;
            }
        }
    }

    public ScientificLibraryHall getElemData(int n) {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return null;
        } else {
            if (n == 0) {
                return tail.data;
            }
            Item2 temp = tail;
            int i = 0;
            do {
                temp = temp.next;
                i++;
            } while (i != n && temp != tail);
            if (temp == tail) {
                return null;
            } else {
                return temp.data;
            }
        }
    }

    public void add(ScientificLibraryHall data) {
        Item2 temp = new Item2(data);
        if (isEmpty()) {
            head.next = temp;
            tail = head.next;
            quantity++;
        } else {
            head.next.next = temp;
            head.next = temp;
            head.next.next = tail;
            quantity++;
        }
    }

    public boolean addAt(int n, ScientificLibraryHall data) {
        Item2 temp = new Item2(data);
        if (n == quantity) {
            switch (n) {
                case 0 -> {
                    head.next = temp;
                    tail = head.next;
                    quantity++;
                }
                case 1 -> {
                    temp.next = tail.next;
                    tail.next = temp;
                    head.next = temp;
                    head.prev = tail;
                    quantity++;
                    return true;
                }
                default -> {
                    temp.next = getElem(n - 1).next;
                    getElem(n - 1).next = temp;
                    temp.prev = getElem(n - 1);
                    head.next = temp;
                    quantity++;
                    return true;
                }
            }

        } else {
            if (n == 0) {
                temp.next = tail;
                tail = temp;
                head.next.next = temp;
                quantity++;
                return true;
            }
            if (n == 1) {
                temp.next = tail.next;
                tail.next = temp;
                temp.prev = tail;
                quantity++;
                return true;
            }
            temp.next = getElem(n - 1).next;
            getElem(n - 1).next = temp;
            temp.prev = getElem(n - 1);
            quantity++;

            return true;
        }
        return true;
    }

    public boolean removeAt(int n) {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return false;
        } else {
            if (n == 0) {
                tail = tail.next;
                head.next.next = tail;
                tail.prev = head.next;
                quantity--;
                return true;
            }
            getElem(n - 1).next.next.prev = getElem(n - 1).next;
            getElem(n - 1).next = getElem(n - 1).next.next;
            quantity--;
            return true;
        }
    }

}
