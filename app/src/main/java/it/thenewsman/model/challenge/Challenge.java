package it.thenewsman.model.challenge;

import java.util.Collection;

import it.thenewsman.model.news.News;

/**
 * Created by enrico on 10/26/17.
 */

public interface Challenge {

    ChallengeType getType();
    Collection<News> getNews();

}
