package it.thenewsman.model.news;

import java.util.Collection;

/**
 * Created by enrico on 11/9/17.
 */
public class NewsDAO implements DAO<News> {
    @Override
    public int insert(News news) {
        return 0;
    }

    @Override
    public boolean delete(News news) {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public News select() {
        return null;
    }

    @Override
    public Collection<News> selectMany() {
        return null;
    }
}
