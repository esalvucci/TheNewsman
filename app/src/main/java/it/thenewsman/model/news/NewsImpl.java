package it.thenewsman.model.news;

import java.util.Collection;
import java.util.Set;

import it.thenewsman.model.Level;

/**
 * Concrete implementation of {@link News} interface.
 * This class wraps the concept of a news and its infos.
 */
public class NewsImpl implements News {

    private String title;
    private String text;
    private String url;
    private String source;
    private String image;
    private Level difficulty;
    private Set<CategoryNews> categories;
    private Set<String> adjectives;
    private Set<String> emotions;
    private boolean isTrue;

    /**
     * Constructor of a News. It inits all fields.
     * @param title of the news.
     * @param text, the content of the news.
     * @param url, the link from which the news comes from.
     * @param source, the newspaper (or more generally from who) the news comes from.
     * @param image, an image related to the news and present in the original url.
     * @param difficulty, an indicator of the news difficulty. It is choosed by who insert the news.
     * @param categories, a set of {@link CategoryNews } which the news belongs to.
     * @param adjectives, a set of adjectives, represented as strings, related to the news.
     * @param emotions, a set of emotions aroused by the news (represented as strings).
     * @param isTrue, whether the news is to be considered true or false.
     */
    public NewsImpl(String title, String text, String url, String source, String image, Level difficulty,
                    Set<CategoryNews> categories, Set<String> adjectives, Set<String> emotions,
                    boolean isTrue) {
        this.title = title;
        this.text = text;
        this.url = url;
        this.source = source;
        this.image = image;
        this.difficulty = difficulty;
        this.isTrue = isTrue;
        this.categories = categories;
        this.adjectives = adjectives;
        this.emotions = emotions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitle() {
        return this.title;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText() {
        return this.text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUrl() {
        return this.url;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSource() {
        return this.source;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getImage() {
        return this.image;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Level getDifficulty() {
        return this.difficulty;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<CategoryNews> getCategories() {
        return this.categories;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<String> getAdjectives() {
        return this.adjectives;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<String> getEmotions() {
        return this.emotions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTrue() {
        return this.isTrue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsImpl news = (NewsImpl) o;

        if (!title.equals(news.title)) return false;
        if (url != null ? !url.equals(news.url) : news.url != null) return false;
        if (source != null ? !source.equals(news.source) : news.source != null) return false;
        return image != null ? image.equals(news.image) : news.image == null;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NewsImpl{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", source='" + source + '\'' +
                ", image='" + image + '\'' +
                ", difficulty=" + difficulty +
                ", categories=" + categories +
                ", adjectives=" + adjectives +
                ", emotions=" + emotions +
                ", isTrue=" + isTrue +
                '}';
    }
}
