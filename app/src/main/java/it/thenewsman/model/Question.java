package it.thenewsman.model;

import java.io.Serializable;
import java.util.Random;

/**
 * Represents all questions category
 */

public enum Question implements Serializable {

    BOOLEAN("Seleziona l'informazione della notizia che ritieni più realistica"),
    CATEGORY("L'informazione è di.."),
    ADJECTIVES("Questo è.."),
    EMOTIONS("Questo provoca emozioni di..");

    private String formulation;

    Question(String formulation) {
        this.formulation = formulation;
    }

    /**
     * @return the text of the question.
     * For example it will be printed during a challenge to ask the user about a news.
     */
    public String getFormulation() {
        return this.formulation;
    }

    /**
     * @return a random question. It would be useful to choose a question during a challenge.
     */
    public static Question getRandomQuestion() {
        Question[] questions = values();
        Random random = new Random();

        return questions[random.nextInt(questions.length)];
    }

    @Override
    public String toString() {
        return "Question{" +
                "formulation='" + formulation + '\'' +
                '}';
    }
}
