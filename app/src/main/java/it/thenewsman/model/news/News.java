package it.thenewsman.model.news;

import java.util.Collection;

import it.thenewsman.model.Level;

/**
 * Models the news concept providing methods to wrap it.
 */

public interface News {

    /**
     * @return the title of a news.
     */
    String getTitle();

    /**
     * @return the content of a news.
     */
    String getText();

    /**
     * @return the url from which the news comes from.
     */
    String getUrl();

    /**
     * @return the source as, for example, which newspaper (or generally who) published it.
     */
    String getSource();

    /**
     * @return an image related to the news and present in the original url.
     */
    String getImage();

    /**
     * @return an indicator of the news difficulty. It is choosed by who insert the news.
     */
    Level getDifficulty();

    /**
     * @return whether the news is to be considered true or false.
     */
    boolean isTrue();

    /**
     * @return a set of {@link CategoryNews } which the news belongs to.
     */
    Collection<String> getCategories();

    /**
     * @return a set of adjectives, represented as strings, related to the news.
     */
    Collection<String> getAdjectives();

    /**
     * @return a set of emotions aroused by the news (represented as strings).
     */
    Collection<String> getEmotions();

}
