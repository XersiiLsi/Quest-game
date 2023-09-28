package mainCharacter;

import mainCharacter.quality.BadSkills;
import mainCharacter.quality.GoodSkills;
import mainCharacter.quality.Phobias;
import java.util.*;

public class Feature {

    private  final List<BadSkills> badSkillsList = new ArrayList<>();
    private  final List<GoodSkills> goodSkillsList = new ArrayList<>();
    private  final List<Phobias> phobiasList = new ArrayList<>();

    Feature() {
        goodSkillsList.add(getRandomEnumValue(GoodSkills.class));
        goodSkillsList.add(getRandomEnumValue(GoodSkills.class));
        goodSkillsList.add(getRandomEnumValue(GoodSkills.class));

        for (int i = 0; i < 4; i++) {
            badSkillsList.add(getRandomEnumValue(BadSkills.class));
        }

        if (getNumber() == 2) {
            phobiasList.add(getRandomEnumValue(Phobias.class));
            phobiasList.add(getRandomEnumValue(Phobias.class));
        } else
            phobiasList.add(getRandomEnumValue(Phobias.class));

        featureChecker();
    }


    public  List<BadSkills> getBadSkillsList() {
        return badSkillsList;
    }

    public  List<GoodSkills> getGoodSkillsList() {
        return goodSkillsList;
    }

    public  List<Phobias> getPhobiasList() {
        return phobiasList;
    }


    private  void featureChecker() {
        replace(goodSkillsList, GoodSkills.class);
        replace(badSkillsList, BadSkills.class);
        replace(phobiasList, Phobias.class);
    }


    private static <T extends Enum<?>> T getRandomEnumValue(Class<T> enumClass) {
        Random random = new Random();
        int index = random.nextInt(enumClass.getEnumConstants().length);
        return enumClass.getEnumConstants()[index];
    }

    private int getNumber() {
        int max = 2;
        int min = 1;
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
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

    @Override
    public String toString() {
        return " Good skills: " + getGoodSkillsList() + "\n Bad Skills: " + badSkillsList
                + "\n Phobias: " + phobiasList;
    }

}
