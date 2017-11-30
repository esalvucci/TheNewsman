package it.thenewsman.model.news;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import it.thenewsman.model.Level;
import it.thenewsman.model.dao.greendao.converter.GreenConverter;
import it.thenewsman.model.dao.greendao.converter.LevelConverter;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Concrete implementation of {@link News} interface.
 * This class wraps the concept of a news and its infos.
 */
@Entity
public class NewsImpl implements News, Serializable {

    private static final long serialVersionUID = 4L;

    @Id(autoincrement = true)
    private long id;
    @NonNull
    private String title = "";
    @NotNull
    private String text;
    @NonNull
    private String url = "";
    private String source;
    @NotNull
    private String image;
    @NotNull
    @Convert(converter = LevelConverter.class, columnType = Integer.class)
    private Level difficulty;
    @Convert(converter = GreenConverter.class, columnType = String.class)
    private List<String> categories;
    @Convert(converter = GreenConverter.class, columnType = String.class)
    private List<String> adjectives;
    @Convert(converter = GreenConverter.class, columnType = String.class)
    private List<String> emotions;
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
    public NewsImpl(@NonNull String title, String text, @NonNull String url, String source, String image, Level difficulty,
                    List<String> categories, List<String> adjectives, List<String> emotions,
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

    @Generated(hash = 1408932155)
    public NewsImpl(long id, @NonNull String title, @NonNull String text, @NonNull String url, String source,
            @NonNull String image, @NonNull Level difficulty, List<String> categories, List<String> adjectives,
            List<String> emotions, boolean isTrue) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.url = url;
        this.source = source;
        this.image = image;
        this.difficulty = difficulty;
        this.categories = categories;
        this.adjectives = adjectives;
        this.emotions = emotions;
        this.isTrue = isTrue;
    }

    @Generated(hash = 1183276940)
    public NewsImpl() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
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
    @NonNull
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
    public List<String> getCategories() {
        return this.categories;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getAdjectives() {
        return this.adjectives;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getEmotions() {
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

        if (id != news.id) return false;
        if (!title.equals(news.title)) return false;
        return url.equals(news.url);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + url.hashCode();
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

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDifficulty(Level difficulty) {
        this.difficulty = difficulty;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void setAdjectives(List<String> adjectives) {
        this.adjectives = adjectives;
    }

    public void setEmotions(List<String> emotions) {
        this.emotions = emotions;
    }

    public boolean getIsTrue() {
        return this.isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }
}
