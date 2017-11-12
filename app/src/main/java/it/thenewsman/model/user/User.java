package it.thenewsman.model.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import it.thenewsman.model.Level;
import it.thenewsman.model.challenge.Challenge;

/*
 * Interface that models the concept of the User of the app.
 */
public interface User extends Serializable {

    /**
     * @return the name of the user as a {@link String}.
     */
    String getName();

    /**
     * @return Retrieve the avatar of the user as a {@link String}.
     * The avatar is intended to be an image ({@link it.thenewsman.R.mipmap}) that the user choose representing him/her within the app
     * and during the experience.
     */
    String getAvatar();

    /**
     * @return Points retreived, as an integer, by the user during all the experience.
     */
    int getPoints();

    /**
     * @return the User's age calculated by his/her birth date.
     */
    int getAge();

    /**
     * @return the level which the user has gained.
     */
    Level getLevel();

    /**
     * @return the Challenges which the user has completed.
     */
    Collection<Challenge> getChallenges();

    /**
     * @return If the User has obtained his Acknowledgment, the most important reward.
     */
    boolean hasAcknowledgment();

    /**
     * Sets the name of the User.
     * @param name of the User.
     */
    void setName(String name);

    /**
     * Adds the point retreived by a User, for example, after a Question into a Challenge.
     * @param points retreived by a User.
     */
    void addPoints(int points);

    /**
     * Adds a challenge completed by the User.
     * @param challenge completed by the User.
     */
    void addChallenge(Challenge challenge);

    /**
     * Sets if the User has obtained his Acknowledgment, the most important reward during the
     * experience.
     * @param acknowledgment, boolean value that represents whether the acknowledgment
     *                       has been obtained or not.
     */
    void setAcknowledgment(boolean acknowledgment);

    /**
     * Sets the level which the user has gained.
     * @param level, which could be REPORTER, JOURNALIST OR EDITORIALIST.
     * @see Level
     */
    void setLevel(Level level);
}
