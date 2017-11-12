package it.thenewsman.model.challenge;

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

    private User user;
    private Challenge challenge;
    private int points;
    private boolean isCompleted;
    private List<News> news = new LinkedList<>();
    private final static int NEWS_SIZE = 10;

    public UserChallenge(User user, Challenge challenge) {
        this.user = user;
        this.challenge = challenge;
        this.news.add(new NewsImpl("Le foto sensazionali di Venezia ghiacciata!",
                "Nelle ultime settimana l’Italia è stata invasa da freddo e neve, persino al sud si sono verificate abbondanti nevicate. Ma questo inizio 2017 verrà ricordato soprattutto per un evento che non ha precedenti nella storia. La laguna e i canali di Venezia si sono completamente congelati, l’acqua è diventata ghiaccio e si prevede che questo “congelamento” duri ancora per qualche giorno. Venezia è solita ad abbondanti nevicate durante l’inverno, tuttavia le basse temperature, insieme a una particolare umidità, hanno creato un totale congelamento dei canali.",
                "http://archive.is/p2jrB#selection-277.0-277.557",
                "Il Giornale Italiano",
                "https://archive.is/p2jrB/c96d9e7b039dcf2017d07049639d559acc0cc5a2.jpg",
                Level.REPORTER,
                null,
                null,
                null,
                false
                ));
        this.news.add(new NewsImpl("La foto della famiglia terrorizzata in posa con il dittatore nordcoreano Kim Jong Un ",
                "una foto ritrae un sorridente Kim Jong Un, dittatore della Corea del Nord, insieme a una famiglia vistosamente angosciata. ",
                "http://www.huffingtonpost.co.uk/2012/08/20/kim-jong-un-photo-north-korea-family_n_1810367.html",
                "Huffington Post",
                "https://2.bp.blogspot.com/-8BfTNsBrZzI/Vty-UuI9GtI/AAAAAAAAf0I/oMPRoqyumYc/s1600/kim-jong-un-terrified-family.jpg",
                Level.REPORTER,
                null,
                null,
                null,
                true
                ));
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

