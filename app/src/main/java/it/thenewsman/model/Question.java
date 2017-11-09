package it.thenewsman.model;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by enrico on 11/6/17.
 */

public enum Question implements Serializable {

    BOOLEAN("Ritengo l'informazione.."),
    CATEGORY("L'informazione è di.."),
    ADJECTIVES("Questo è.."),
    EMOTIONS("Questo provoca emozioni di..");

    private String formulation;

    Question(String formulation) {
        this.formulation = formulation;
    }

    public String getFormulation() {
        return this.formulation;
    }

    public static Question getRandomQuestion() {
        Question[] questions = values();
        Random random = new Random();

        return questions[random.nextInt(questions.length)];

    }
    
}
