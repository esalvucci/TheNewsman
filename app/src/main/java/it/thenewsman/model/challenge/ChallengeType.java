package it.thenewsman.model.challenge;

import com.example.enrico.fakenews.R;

/**
 *
 */

public enum ChallengeType {
    TITLE("", R.mipmap.ic_launcher),
    PHOTO("foto", R.mipmap.ic_launcher),
    URL("url", R.mipmap.ic_launcher),
    SOURCE(" ", R.mipmap.ic_launcher);

    private String formulation;
    private int badge;

    ChallengeType(String formulation, int badge) {
        this.formulation = formulation;
        this.badge = badge;
    }

    public String getFormulation() {
        return this.formulation;
    }
    public int getBadge() {
        return this.badge;
    }

    public String toString() {
        return this.name() + ":" +
                "\nFormulazione della domanda: " + this.formulation +
                "\nBadge: " + this.badge;
    }

}
