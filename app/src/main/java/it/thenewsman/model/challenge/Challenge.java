package it.thenewsman.model.challenge;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import it.thenewsman.R;
import it.thenewsman.model.news.News;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Models the concept of challenge which a user performs to gain points.
 * It has a label, used as advice for the user, and it is represented by a graphic badge.
 */
@Entity
public class Challenge implements Serializable {
/*
    TITLE(R.string.title_challenge, R.mipmap.title_card),
    PHOTO(R.string.photo_challenge, R.mipmap.photo_card),
    URL(R.string.url_challenge, R.mipmap.url_card),
    CONTENT(R.string.content_challenge, R.mipmap.source_card),
    BONUS(R.string.bonus_challenge, R.mipmap.default_news_image),
    UNKNOWN(R.string.unknown, R.drawable.ic_info_24dp);
    */

    private static final long serialVersionUID = 4L;

    @Id
    private long id;
    private int label;
    private int badge;
    private String name;

    public Challenge(String name, int label, int badge) {
        this.label = label;
        this.badge = badge;
    }

    @Generated(hash = 2099114862)
    public Challenge() {
    }

    @Generated(hash = 590480882)
    public Challenge(long id, int label, int badge, String name) {
        this.id = id;
        this.label = label;
        this.badge = badge;
        this.name = name;
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
    public String getName() {
        return this.name;
    }

    /**
     * @return the graphic badge of the challenge
     */
    public int getBadge() {
        return this.badge;
    }

    public String toString() {
        return "Challenge:" +
                "\nFormulazione della domanda: " + this.label +
                "\nBadge: " + this.badge;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public void setName(String name) {
        this.name = name;
    }

}
