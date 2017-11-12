package it.thenewsman.controller.question;

import android.os.Bundle;
import android.widget.TextView;

import it.thenewsman.R;
import it.thenewsman.controller.ToolbarActivity;
import it.thenewsman.model.Question;
import it.thenewsman.model.challenge.UserChallenge;

public abstract class AnswerActivity extends ToolbarActivity {

    private UserChallenge userChallenge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.userChallenge = (UserChallenge) getIntent()
                .getSerializableExtra("UserChallengeIntent");
        getSupportActionBar().setTitle(
                getResources().getString(this.userChallenge.getChallenge().getLabel()));

        this.setAnswers();
    }

    public void setQuestionFormulation(String formulation) {
        TextView textView = (TextView) findViewById(R.id.question_formulation);
        textView.setText(formulation);
    }

    public void startNextActivity() {

        // start nextActivity
        finish();
    }

    public abstract void setAnswers();

    // public void setChallengeProgress() {}

    protected UserChallenge getUserChallenge() {
        return this.userChallenge;
    }
}
