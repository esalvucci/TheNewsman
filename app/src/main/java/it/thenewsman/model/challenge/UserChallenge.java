package it.thenewsman.model.challenge;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import it.thenewsman.model.Level;
import it.thenewsman.model.news.CategoryNews;
import it.thenewsman.model.news.Emotion;
import it.thenewsman.model.news.News;
import it.thenewsman.model.news.NewsImpl;
import it.thenewsman.model.user.User;

/**
 * Created by enrico on 10/26/17.
 */

public class UserChallenge implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id(autoincrement = true)
    private long id;
    @NonNull
    private User user;
    @NonNull
    private Challenge challenge;
    private int points;
    private boolean isCompleted;
    @ToMany
//    private List<News> news = new LinkedList<>();
    private List<NewsImpl> news = new LinkedList<>();
    private final static int NEWS_SIZE = 10;

    public UserChallenge(@NonNull User user, @NonNull Challenge challenge) {
        this.user = user;
        this.challenge = challenge;
    }

    public void addPoints(int points) {
        this.points = this.points + points;
    }

    @NonNull
    public User getUser() {
        return this.user;
    }

    @NonNull
    public Challenge getChallenge() {
        return this.challenge;
    }

    public int getPoints() {
        return this.points;
    }

    // Filtro solo un numero casuale di notizie su quelle totali
    public News getFilteredNews() {
        int random = new Random().nextInt(this.news.size());
        News n = this.news.get(random);
        this.news.remove(random);   // Rimuovo la notizia già chiesta
        return n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserChallenge that = (UserChallenge) o;

        return user.equals(that.user) && challenge.equals(that.challenge);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + challenge.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserChallenge{" +
                "user=" + user +
                ", challenge=" + challenge +
                ", points=" + points +
                '}';
    }
}

