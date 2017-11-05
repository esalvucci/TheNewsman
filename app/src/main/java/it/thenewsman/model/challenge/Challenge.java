package it.thenewsman.model.challenge;

import android.content.Context;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import it.thenewsman.R;
import it.thenewsman.model.news.News;

/**
 *
 */
public enum Challenge implements Serializable {
    TITLE(R.string.title_challenge, R.mipmap.title_card),
    PHOTO(R.string.title_challenge, R.mipmap.photo_card),
    URL(R.string.title_challenge, R.mipmap.url_card),
//    CONTENT("", R.mipmap.default_news_image);
    SOURCE(R.string.title_challenge, R.mipmap.source_card),
    BONUS(R.string.title_challenge, R.mipmap.default_news_image);

    private int formulation;
    private int badge;
    private Set<News> news = new HashSet<>();

    Challenge(int formulation, int badge) {
        this.formulation = formulation;
        this.badge = badge;
//        this.news.addAll();
    }

    public Set<News> getNews() {
        return this.news;
    }
    public int getFormulation() {
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
