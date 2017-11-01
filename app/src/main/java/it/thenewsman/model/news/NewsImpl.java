package it.thenewsman.model.news;

import java.util.Collection;
import java.util.Set;

/**
 * Created by enrico on 10/31/17.
 */

public class NewsImpl implements News {

    private String title;
    private String text;
    private String url;
    private String image;
    private int difficulty;
    private Set<CategoryNews> categories;
    private Set<String> adjectives;
    private Set<String> emotions;
    private boolean isTrue;

    public NewsImpl(String title, String text, String url, String image, int difficulty,
                    Set<CategoryNews> categories, Set<String> adjectives, Set<String> emotions,
                    boolean isTrue) {
        this.title = title;
        this.text = text;
        this.url = url;
        this.image = image;
        this.difficulty = difficulty;
        this.isTrue = isTrue;
        this.categories = categories;
        this.adjectives = adjectives;
        this.emotions = emotions;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getImage() {
        return this.image;
    }

    @Override
    public int getDifficulty() {
        return this.difficulty;
    }

    @Override
    public Collection<CategoryNews> getCategories() {
        return this.categories;
    }

    @Override
    public Collection<String> getAdjectives() {
        return this.adjectives;
    }

    @Override
    public Collection<String> getEmotions() {
        return this.emotions;
    }

    @Override
    public boolean isTrue() {
        return this.isTrue;
    }

}
