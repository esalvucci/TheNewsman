package it.thenewsman.controller.question;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import it.thenewsman.R;
import it.thenewsman.controller.ToolbarActivity;
import it.thenewsman.model.Question;
import it.thenewsman.model.challenge.Challenge;
import it.thenewsman.model.challenge.UserChallenge;
import it.thenewsman.model.user.UserImpl;

public class QuestionActivity extends ToolbarActivity implements BooleanQuestionFragment.OnFragmentInteractionListener {

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_question);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Challenge userChallenge = (Challenge) getIntent().getSerializableExtra("UserChallengeIntent");

        Log.d("UserChallenge", userChallenge.toString());

        Resources resources = this.getApplicationContext().getResources();
        this.getSupportActionBar().setTitle(resources.getText(userChallenge.getFormulation()));

        Fragment fragment = BooleanQuestionFragment.newInstance(userChallenge);
        fragment.setArguments(getIntent().getExtras());

        getSupportFragmentManager().beginTransaction()
                .add(fragment, "questionFragment")
                .addToBackStack("A_B_TAG")
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
