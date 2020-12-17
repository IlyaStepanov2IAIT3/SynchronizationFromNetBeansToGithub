package Lists;

import Libraries.*;

public class Item2 {

    public ScientificLibraryHall data;
    public Item2 prev;
    public Item2 next;

    public Item2() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    public Item2(ScientificLibraryHall data) {
        this.data = data;
    }
}
