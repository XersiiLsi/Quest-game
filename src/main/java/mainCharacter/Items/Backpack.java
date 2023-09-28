package mainCharacter.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Backpack {
    private List<Item> inventory = new ArrayList<>();
    public Backpack() {
        for (int i = 0; i < 8; i++) {
            inventory.add(getRandomEnumValue(Item.class));
        }
        replace(inventory , Item.class);
    }
    private static <T extends Enum<?>> void replace(List list, Class<T> enumClass) {
        boolean replicate = false;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    if (list.get(i).equals(list.get(j))) {
                        list.set(i, getRandomEnumValue(enumClass));
                        replicate = true;

                    }
                }
            }
        }
        if (replicate) {
            replace(list, enumClass);
        }
    }

    private static <T extends Enum<?>> T getRandomEnumValue(Class<T> enumClass) {
        Random random = new Random();
        int index = random.nextInt(enumClass.getEnumConstants().length);
        return enumClass.getEnumConstants()[index];
    }
    public List getInventory() {
        return inventory;
    }

}
