package it.thenewsman.model.challenge;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import it.thenewsman.R;
import it.thenewsman.model.news.News;

/**
 * Models the concept of challenge which a user performs to gain points.
 * It has a label, used as advice for the user, and it is represented by a graphic badge.
 */
public enum Challenge implements Serializable {
    TITLE(R.string.title_challenge, R.mipmap.title_card),
    PHOTO(R.string.photo_challenge, R.mipmap.photo_card),
    URL(R.string.url_challenge, R.mipmap.url_card),
    CONTENT(R.string.content_challenge, R.mipmap.source_card),
    BONUS(R.string.bonus_challenge, R.mipmap.default_news_image);

    private int label;
    private int badge;

    Challenge(int label, int badge) {
        this.label = label;
        this.badge = badge;
    }

    /**
     * @return the label of the challenge used as advice for the user.
     */
    public int getLabel() {
        return this.label;
    }

    /**
     * @return the graphic badge of the challenge
     */
    public int getBadge() {
        return this.badge;
    }

    /**
     * @return the news which the user has to answer in the challenge.
     */
    public Collection<News> getNews() {
        return new HashSet<News>();
    }

    public String toString() {
        return this.name() + ":" +
                "\nFormulazione della domanda: " + this.label +
                "\nBadge: " + this.badge;
    }

}
