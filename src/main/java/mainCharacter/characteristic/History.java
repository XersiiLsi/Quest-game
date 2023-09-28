package mainCharacter.characteristic;

import java.util.ArrayList;
import java.util.List;

public class History {
    private String history;
    private List<String> stories = new ArrayList<>();

    public History() {
        stories.add("Your life has begun to feel like groundhog day, \n  " +
                "you took the tickets, packed your suitcase and got ready to go...");
        stories.add("Your boss, in the hope that, <br> " +
                "that the best employee of the month will be able to rest \n" +
                "bought tickets to miami. <br> " +
                "you packed your things and hit the road");
        stories.add("You were fired and replaced by the director's son, \n" +
                "but you decided not to lose heart, bought tickets, \n " +
                "packed suitcase and was even happy...");
    }


    private int getRandomNumber() {
        int max = 2;
        int min = 1;
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    public String getHistory(Profession profession) {
        if (profession == Profession.Lawyer) {
            return "The twins gave you the money, you took it home," +
                    " \n" + "stuck it in your luggage " + "bought plane tickets \n"
                    + "and decided to live large";
        }
        if (profession == Profession.Chemist) {
            return "You have a lot of money, but your life has slipped into an abyss \n" +
                    "your last wish is to relax on an island, \n" +
                    " forgetting about your empire...";
        }
        if (profession == Profession.Thief) {
            return "Wherever you are you will always be found \n" +
                    "With such thoughts, you packed your things and bought a ticket to the island... ";
        } else
            return stories.get(getRandomNumber());

    }

}
