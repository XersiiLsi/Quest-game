package mainCharacter.characteristic;

public enum Profession {
    DrugLord("drug lord" , "наркоборон"),
            Hunter("hunter" , "охотник"),
    Medic("medic" , "медик"),
            Chemist("chemist" , "химик"),
    Vet("vet" , "ветеринар") ,

            Botanist("botanist" , "ботаник"),
    Pathfinder("pathfinder" , "следопыт"),
            Thief("thief" , "вор"),

    Worker("worker" , "рабочий"),
            Waitress("waitress" , "официантка"),
    Programmer("programmer" , "программист"),
            Surgeon("surgeon" , "хирург"),
    Biologist("biologist" , "биолог"),
            Rescuer("rescuer" , "спасатель"),
    Geographer("geographer", "географ"),
            Confectioner("confectioner" , "кондитерша"),
    Judge("judge" , "судья"),
    Lawyer("lawyer" , "адвокат"),
    Blogger("blogger" , "блоггер"),

            PoliceOfficer("police officer" , "офицер полиции");


    Profession(String name, String nameRu) {
        this.name = name;
        this.nameRu = nameRu;
    }

    final String name;
    final String nameRu;

    }
