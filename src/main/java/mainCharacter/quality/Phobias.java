package mainCharacter.quality;

public enum Phobias {
    ablutophobia("fear of washing"), arachnophobia("fear of spiders"), acrophobia("Fear of heights"),
    anthropophobia("fear of groups"), algophobia("fear of pain"),
    anthophobia("fear of flowers"), nyctophobia("fear of darkness, night"),
    herpetophobia("fear of reptiles, reptiles, snakes"), xylophobia("fear of the forest"),
    hypnophobia("fear of falling asleep"), zoophobia("fear of animals"),
    insectophobia("fear of insects"), claustrophobia("fear of closed space"),
    coulrophobia("fear of clowns"), myrmecophobia("fear of ants"),
    Musophobia("fear of mice and rats"), paraskavedekatriaphobia("fear of Friday, the 13th day of the month"),
    pettophobia("fear of gas incontinence"), triskaidekaphobia("fear of number 13"),
    tunnelphobia("fear of going through a tunnel"), phasmophobia("fear of ghosts and spirits");


    Phobias(String description) {
        this.description = description;
    }

    final String description;

}
