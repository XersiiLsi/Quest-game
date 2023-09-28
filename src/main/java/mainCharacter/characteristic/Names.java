package mainCharacter.characteristic;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private List<String> names = new ArrayList<>();

    public Names() {
        names.add("Antonio");
        names.add("Derick");
        names.add("Jordi");
        names.add("Walter");
        names.add("Abdul");
        names.add("Mike");
        names.add("John");
        names.add("Maxim");
        names.add("Jim");
        names.add("Julia");
        names.add("Bill");
        names.add("Dima");
        names.add("Oleg");
        names.add("Carl");
        names.add("kile");
        names.add("Anna");
        names.add("Georgiy");
        names.add("Saul");
        names.add("Jimmy");
        names.add("Rick");
    }

    public String getNames(int index) {
        return names.get(index);
    }
}
