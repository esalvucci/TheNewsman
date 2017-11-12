package it.thenewsman.model.dao;

import it.thenewsman.model.challenge.ChallengeDAO;
import it.thenewsman.model.news.NewsDAO;
import it.thenewsman.model.user.UserDAO;

/**
 * Created by enrico on 11/9/17.
 */

class MySqlDAOFactory extends DAOFactory {
    @Override
    public ChallengeDAO getChallengeDAO() {
        return null;
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAO();
    }

    @Override
    public NewsDAO getNewsDAO() {
        return null;
    }
}
