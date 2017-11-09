package it.thenewsman.model.challenge;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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

    private User user;
    private Challenge challenge;
    private int points;
    private boolean isCompleted;
    private final static int NEWS_SIZE = 10;

    public UserChallenge(User user, Challenge challenge) {
        this.user = user;
        this.challenge = challenge;
    }

    public void addPoints(int points) {
        this.points = this.points + points;
    }

    public User getUser() {
        return this.user;
    }

    public Challenge getChallenge() {
        return this.challenge;
    }

    public int getPoints() {
        return this.points;
    }

    // Filtro solo un numero casuale di notizie su quelle totali
    public News getFilteredNews() {
//        Random rand = new Random();
//        List<News> wordList = rand.ints(NEWS_SIZE, 0, NewsDataManager.getSize());

        Set<CategoryNews> set =  new HashSet<>();
        set.add(CategoryNews.PROPAGANDA);
        set.add(CategoryNews.INFORMATION);
        set.add(CategoryNews.ADVERTISEMENT);

        Set<String> adejctives = new HashSet<>();
        adejctives.add("aggettivo");

        Set<String> emotions = new HashSet<>();
        emotions.add(Emotion.CURIOSITY.getName());
        emotions.add(Emotion.AMAZEMENT.getName());
        emotions.add(Emotion.FEAR.getName());

        return new NewsImpl("Le foto sensazionali di Venezia ghiacciata!",
                "Nelle ultime settimana l’Italia è stata invasa da freddo e neve," +
                        "persino al sud si sono verificate abbondanti nevicate. Ma questo inizio" +
                        "2017 verrà ricordato soprattutto per un evento che non ha precedenti nella" +
                        "storia. La laguna e i canali di Venezia si sono completamente congelati," +
                        "l’acqua è diventata ghiaccio e si prevede che questo 'congelamento' duri" +
                        "ancora per qualche giorno. Venezia è solita ad abbondanti nevicate durante" +
                        "l’inverno, tuttavia le basse temperature, insieme a una particolare umidità," +
                        "hanno creato un totale congelamento dei canali.",
                "http://archive.is/p2jrB#selection-277.0-277.557",
                "https://archive.is/p2jrB/c96d9e7b039dcf2017d07049639d559acc0cc5a2.jpg",
                Level.REPORTER, set, adejctives, emotions, true);

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

