package it.thenewsman.model;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * Represents the level reached by the user during the experience.
 */
public enum Level {

    REPORTER("Reporter", 1),
    JOURNALIST("Giornalista", 2),
    EDITORIALIST("Editorialista", 3),
    UNKNOWN("unknown", 0);

    public final String name;
    public final int level;

    Level(String name, int level) {
        this.name = name;
        this.level = level;
    }

    /**
     * @return the name of the level.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the integer rapresenting which level the user reached.
     */
    public int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Level: " + this.level;
    }

}
