package perso.woodyzuill.aging;

import perso.woodyzuill.Item;

public class ForeverYoung implements AgingStrategy {
    @Override
    public Item age(Item item) {
        return item;
    }
}
