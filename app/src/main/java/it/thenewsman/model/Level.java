package it.thenewsman.model;

/**
 * Created by enrico on 11/1/17.
 */

public enum Level {

    REPORTER("Reporter", 1),
    JOURNALIST("Giornalista", 2),
    EDITORIALIST("Editorialista", 3);

    public final String name;
    public final int level;

    Level(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Level: " + this.level;
    }

}
