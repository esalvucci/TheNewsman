package it.thenewsman.model.user;

import java.util.Date;

import it.thenewsman.model.challenge.Challenge;

/**
 * Interface for modelling the concept of the User of the app.
 */

public interface User {

    /**
     * @return Retrieve the name of the user as a {@link String}
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
     * @return Retreive the User's age calculated by his/her birth date.
     */
    int getAge();

    /**
     * @return If the User has obtained his Acknowledgment, the most important reward.
     */
    boolean hasAcknowledgment();

    /**
     * Sets the name of the User
     * @param name
     */
    void setName(String name);

    /**
     * Adds the point retreived by a user, for example, after a Question into a Challenge.
     * @param points
     */
    void addPoints(int points);

    /**
     * Adds a challenge completed by the User
     * @param challenge completed by the user
     */
    void addChallenge(Challenge challenge);

    /**
     * Sets if the User has obtained his Acknowledgment, the most important reward during the
     * experience
     * @param acknowledgment 
     */
    void setAcknowledgment(boolean acknowledgment);
}
