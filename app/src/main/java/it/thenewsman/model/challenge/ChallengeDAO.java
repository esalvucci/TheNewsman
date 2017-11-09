package it.thenewsman.model.challenge;

import java.util.Collection;

import it.thenewsman.model.dao.DAO;

/**
 * Created by enrico on 11/9/17.
 */

public class ChallengeDAO implements DAO<Challenge> {
    @Override
    public int insert(Challenge c) {
        return 0;
    }

    @Override
    public boolean delete(Challenge c) {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public Challenge select() {
        return null;
    }

    @Override
    public Collection<Challenge> selectMany() {
        return null;
    }
}
