package it.thenewsman.model.challenge;

import com.example.enrico.fakenews.model.news.News;

import java.util.Collection;

/**
 * Created by enrico on 10/26/17.
 */

public interface Challenge {

    ChallengeType getType();
    Collection<News> getNews();

}
