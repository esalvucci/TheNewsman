package it.thenewsman.model.news;

import java.util.Collection;

/**
 * Created by enrico on 10/31/17.
 */

public interface News {

    String getTitle();
    String getText();
    String getUrl();
    String getImage();
    int getDifficulty();
    boolean isTrue();
    Collection<CategoryNews> getCategories();
    Collection<String> getAdjectives();
    Collection<String> getEmotions();

}
