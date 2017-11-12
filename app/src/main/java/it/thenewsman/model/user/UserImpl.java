package it.thenewsman.model.user;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.thenewsman.model.Level;
import it.thenewsman.model.challenge.Challenge;

/**
 * Concrete implementation of User concept.
 */
public class UserImpl implements User{

    private String name;
    private String avatar;
    private int points = 0;
    private Date birthday;
    private boolean acknowledgment = false;
    private Level level;
    private Set<Challenge> challenges = new HashSet<>();

    /**
     *
     * @param name of the user.
     * @param avatar, image representing the user during the experience.
     * @param points gained by the user.
     * @param birthday of the user, it be useful to calculate his age and measure news' difficulty
     *                 according to it.
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
    public void addChallenge(Challenge challenge) {
        this.challenges.add(challenge);
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
     *
     * {@inheritDoc}
     */
    @Override
    public Collection<Challenge> getChallenges() {
        return this.challenges;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasAcknowledgment() {
        return this.acknowledgment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserImpl user = (UserImpl) o;

        if (!name.equals(user.name)) return false;
        return avatar != null ? avatar.equals(user.avatar) : user.avatar == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        return result;
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
