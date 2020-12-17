package Lists;

import Libraries.*;

public class Item {

    public ScientificBook data;
    public Item next;

    public Item() {
        this.data = null;
        this.next = null;
    }

    public Item(ScientificBook data) {
        this.data = data;
    }
}
