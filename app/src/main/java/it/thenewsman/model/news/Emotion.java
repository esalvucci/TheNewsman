package it.thenewsman.model.news;

/**
 * Created by enrico on 11/8/17.
 */

public enum Emotion {

    ANGER("rabbia"),
    AMAZEMENT("stupore"),
    CURIOSITY("curiosità"),
    JOY("gioia"),
    FEAR("paura"),
    SADNESS("tristezza"),
    EUPHORIA("euforia"),
    HOPE("speranza");

    private String name;

    Emotion(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
