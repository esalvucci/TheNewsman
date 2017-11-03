package it.thenewsman.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import it.thenewsman.R;

public class QuestionActivity extends ToolbarActivity {

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_question);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Prova");
    }
}
