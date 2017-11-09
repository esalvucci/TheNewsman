package it.thenewsman.model.dao;

import it.thenewsman.model.challenge.ChallengeDAO;
import it.thenewsman.model.news.NewsDAO;
import it.thenewsman.model.user.UserDAO;

/**
 * Created by enrico on 11/9/17.
 */
public abstract class DAOFactory {

    protected enum DAOType {
        SQLITE, MYSQLITE, JSON;
    }

    public abstract ChallengeDAO getChallengeDAO();
    public abstract UserDAO getUserDAO();
    public abstract NewsDAO getNewsDAO();

    public static DAOFactory getDaoFactory(DAOType type) {

        switch (type) {
            case SQLITE:
                return new SQLiteDAOFactory();
            case MYSQLITE:
                return new MySqlDAOFactory();
            case JSON:
                return new JsonDAOFactory();
            default:
                return new MySqlDAOFactory();
        }
    }
}
