package it.thenewsman.model.challenge;

import java.util.HashSet;
import java.util.Set;

import it.thenewsman.R;
import it.thenewsman.model.news.News;

/**
 *
 */
public enum Challenge {
    TITLE("", R.drawable.ic_badge_48dp),
    PHOTO("foto", R.drawable.ic_licence_24dp),
    URL("url", R.drawable.ic_info_24dp),
    SOURCE(" ", R.drawable.ic_launcher_background),
    BONUS("Bonus", R.drawable.ic_launcher_foreground);

    private String formulation;
    private int badge;
    private Set<News> news = new HashSet<>();

    Challenge(String formulation, int badge) {
        this.formulation = formulation;
        this.badge = badge;
//        this.news.addAll();
    }

    public Set<News> getNews() {
        return this.news;
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
                "\nBadge: " + this.badge +
                "\nNews: " + this.news;
    }

}
