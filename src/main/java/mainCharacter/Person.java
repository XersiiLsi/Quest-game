package mainCharacter;

import mainCharacter.Items.*;
import mainCharacter.characteristic.Profession;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private volatile static Person instance;

    Person() {
    }

    public static Person getInstance() {
        Person localInstance = instance;

        if (localInstance == null) {
            synchronized (Person.class) {

                localInstance = instance;

                synchronized (Person.class) {
                    if (localInstance == null) {
                        instance = new Person();
                    }
                }
            }
        }
        return instance;
    }

    private final Feature feature = new Feature();
    private final Character character = new Character();
    private final Backpack backpack = new Backpack();
    private final List<Item> inventory = new ArrayList<>(backpack.getInventory());

    public String badSkills() {
        return feature.getBadSkillsList().toString().replace("{", " ").replace("}", " ");
    }

    public List goodSkills() {
        return feature.getGoodSkillsList();
    }

    public List phobias() {
        return feature.getPhobiasList();
    }


    public String name() {
        return character.getName();
    }

    public Profession profession() {
        return character.getProfession();
    }

    public String history() {
        return character.getHistory();
    }


    public boolean useItem(Item item) {
        inventory.remove(item);
        return true;
    }

    public boolean addItem(Item item) {
        inventory.add(item);
        return true;
    }

    public boolean combinationItem(Item... items) {
        Item creation = CombinationItems.combineItems(items);
        if (creation == null)
            return false;
        inventory.remove(items);
        inventory.add(creation);
        return true;
    }

    @Override
    public String toString() {
        return "Person " + name() + "\n profession: " + profession() + "\n history:  " + history() + "\n" +
                "feature=" + feature + ",\n" +
                " inventory=" + inventory +
                '}';
    }

    public int getNameLength() {
        return name().length();
    }

    public int getProfLength() {
        return profession().toString().length();
    }
}
