package it.thenewsman.model.challenge;

import java.util.HashSet;
import java.util.Set;

import it.thenewsman.R;
import it.thenewsman.model.news.News;

/**
 *
 */
public enum Challenge {
    TITLE("Titolo", R.mipmap.title_card),
    PHOTO("foto", R.mipmap.photo_card),
    URL("url", R.mipmap.url_card),
    SOURCE(" ", R.mipmap.source_card),
    BONUS("Bonus", R.mipmap.default_news_image);

    private String formulation;
    private Integer badge;
    private Set<News> news = new HashSet<>();

    Challenge(String formulation, Integer badge) {
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
    public Integer getBadge() {
        return this.badge;
    }

    public String toString() {
        return this.name() + ":" +
                "\nFormulazione della domanda: " + this.formulation +
                "\nBadge: " + this.badge +
                "\nNews: " + this.news;
    }

}
