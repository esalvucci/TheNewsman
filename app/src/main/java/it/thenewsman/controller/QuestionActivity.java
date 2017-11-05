package it.thenewsman.controller;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import it.thenewsman.R;
import it.thenewsman.model.challenge.Challenge;

public abstract class QuestionActivity extends ToolbarActivity {

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_question);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Challenge challenge = (Challenge) getIntent().getSerializableExtra("challenge");

        Resources resources = this.getApplicationContext().getResources();
        getSupportActionBar().setTitle(resources.getText(challenge.getFormulation()));
    }
}
