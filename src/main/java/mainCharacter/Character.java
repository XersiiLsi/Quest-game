package mainCharacter;

import mainCharacter.characteristic.History;
import mainCharacter.characteristic.Names;
import mainCharacter.characteristic.Profession;

import java.util.Random;

public class Character{
    private Profession profession;
    private String name;
    private String history;
    private static int index;

    public Character() {
        Names names = new Names();
        History history1 = new History();
        profession = getRandomEnumValue(Profession.class);
        name = names.getNames(index);
        history = history1.getHistory(profession);

    }

    public Profession getProfession() {
        return profession;
    }

    public String getName() {
        return name;
    }

    public String getHistory() {
        return history;
    }

    public static int getIndex() {
        return index;
    }

    private static <T extends Enum<?>> T getRandomEnumValue(Class<T> enumClass) {
        Random random = new Random();
        index = random.nextInt(enumClass.getEnumConstants().length);
        return enumClass.getEnumConstants()[index];
    }



}
