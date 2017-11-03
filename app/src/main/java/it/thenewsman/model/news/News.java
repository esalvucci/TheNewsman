package it.thenewsman.model.news;

import java.util.Collection;

import it.thenewsman.model.Level;

/**
 * Created by enrico on 10/31/17.
 */

public interface News {

    String getTitle();
    String getText();
    String getUrl();
    String getImage();
    Level getDifficulty();
    boolean isTrue();
    Collection<CategoryNews> getCategories();
    Collection<String> getAdjectives();
    Collection<String> getEmotions();

}
