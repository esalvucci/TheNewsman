package it.thenewsman.model.user;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.thenewsman.model.Level;
import it.thenewsman.model.challenge.Challenge;

/**
 * Concrete implementation of User concept
 */
public class UserImpl implements User{

    private String name;
    private String avatar;
    private int points = 0;
    private Date birthday;
    private boolean acknowledgment = false;
    private Level level;
    private Map<Challenge, Integer> challenges = new HashMap<>();

    /**
     *
     * @param name
     * @param avatar
     * @param points
     * @param birthday
     */
    public UserImpl(String name, String avatar, int points, Date birthday) {
        this.name = name;
        this.avatar = avatar;
        this.points = points;
        this.birthday = birthday;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPoints(int points) {
        this.points = this.points + points;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAcknowledgment(boolean acknowledgment) {
        this.acknowledgment = acknowledgment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addChallenge(Challenge challenge, int points) {
        this.challenges.put(challenge, points);
        this.points = this.points + points;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAvatar() {
        return this.avatar;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPoints() {
        return this.points;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAge() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Level getLevel() {
        return this.level;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasAcknowledgment() {
        return this.acknowledgment;
    }

    @Override
    public String toString() {
        return "UserImpl{" +
                ", name='" + name + '\'' +
                ", avatar=" + avatar +
                ", points=" + points +
                ", challenges=" + challenges +
                ", acknowledgment=" + acknowledgment +
                '}';
    }
}
