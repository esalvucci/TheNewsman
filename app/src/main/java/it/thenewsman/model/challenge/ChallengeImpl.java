package it.thenewsman.model.challenge;

import com.example.enrico.fakenews.model.news.News;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by enrico on 10/26/17.
 */
public class ChallengeImpl implements Challenge {

    private ChallengeType type;
    private List<News> news;

    public ChallengeImpl(ChallengeType type) {
        this.type = type;
        this.news = this.setNews();
    }

    private List<News> setNews() {

        List<News> list = new LinkedList();

        return list;
    }

    @Override
    public ChallengeType getType() {
        return this.type;
    }

    @Override
    public Collection<News> getNews() {
        return this.news;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChallengeImpl challenge = (ChallengeImpl) o;

        return type == challenge.type && news.equals(challenge.news);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + news.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ChallengeImpl{" +
                "type=" + type +
                ", news=" + news +
                '}';
    }
}
