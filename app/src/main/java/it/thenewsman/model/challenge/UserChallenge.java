package it.thenewsman.model.challenge;

import it.thenewsman.model.user.User;

/**
 * Created by enrico on 10/26/17.
 */

public class UserChallenge {

    private User user;
    private Challenge challenge;
    private int points;

    public UserChallenge(User user, Challenge challenge) {
        this.user = user;
        this.challenge = challenge;
    }

    public void addPoints(int points) {
        this.points = this.points + points;
    }

    public User getUser() {
        return user;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public int getPoints() {
        return this.points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserChallenge that = (UserChallenge) o;

        return user.equals(that.user) && challenge.equals(that.challenge);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + challenge.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserChallenge{" +
                "user=" + user +
                ", challenge=" + challenge +
                ", points=" + points +
                '}';
    }
}

